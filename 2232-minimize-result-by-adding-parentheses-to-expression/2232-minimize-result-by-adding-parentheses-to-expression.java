class Solution {
    public String minimizeResult(String expression) {
        
        String[] strs = expression.split("\\+");
        String first = strs[0];
        String second = strs[1];
        int a = Integer.valueOf(first);
        int b = Integer.valueOf(second);
        // 1. left ( at 0 index, right ) at last
        // 前面不乘法，后面必然无乘法
        int noMul = a + b;
        // 2. left at 1 index, right ) at last
        Map<Integer, String> map = new HashMap<>();
        for (int j = 1; j < first.length(); ++j) {
            int prev = Integer.valueOf(first.substring(0, j));
            String prevstr = first.substring(0, j) + "(" + first.substring(j, first.length());
            int suf = Integer.valueOf(first.substring(j, first.length()));
            
            for (int i = 1; i <= second.length(); ++i) {
                if (i == second.length()) {
                    if (first.length() > 1) {
                        String s2 = prevstr + "+" + second.substring(0, i) + ")";
                        int res2 = prev * (suf + Integer.valueOf(second.substring(0, i)));
                        map.put(res2, s2);
                    }
                    continue;
                }
                String s1 = "(" + first + "+" + second.substring(0, i) + ")" + second.substring(i, second.length());
                int res1 = (a + Integer.valueOf(second.substring(0, i))) 
                    * Integer.valueOf(second.substring(i, second.length()));

                map.put(res1, s1);
                
                // System.out.println(Integer.valueOf(first));
                // System.out.println(Integer.valueOf(second.substring(0, i)));
                // System.out.println(Integer.valueOf(Integer.valueOf(second.substring(i, second.length()))));

                if (first.length() > 1) {
                    String s2 = prevstr + "+" + second.substring(0, i) + ")" + second.substring(i, second.length());

                    int res2 = prev * (suf + Integer.valueOf(second.substring(0, i))) 
                        * Integer.valueOf(second.substring(i, second.length()));

                    // System.out.println(Integer.valueOf(first.charAt(0) - '0'));
                    // System.out.println(Integer.valueOf(Integer.valueOf(first.substring(1, first.length())) 
                    //     + Integer.valueOf(second.substring(0, i))));
                    // System.out.println(Integer.valueOf(Integer.valueOf(second.substring(i, second.length()))));

                    map.put(res2, s2);
                }
            }
        }
        for (int i = 1; i <= second.length(); ++i) {
            if (i == second.length()) {
                continue;
            }
            String s1 = "(" + first + "+" + second.substring(0, i) + ")" + second.substring(i, second.length());
            int res1 = (a + Integer.valueOf(second.substring(0, i))) 
                * Integer.valueOf(second.substring(i, second.length()));

            map.put(res1, s1);
        }
        int min = Integer.MAX_VALUE;
        for (int d : map.keySet()) {
            // System.out.println(d);
            min = Math.min(d, min);
        }
        if (noMul < min) {
            return "(" + expression + ")";
        } else {
            return map.get(min);
        }
    }
}