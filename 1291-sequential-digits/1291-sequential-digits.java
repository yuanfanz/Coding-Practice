class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Set<Integer> result = new HashSet<>();
        
        int start = 0;
        int end = 0;
        
        int l = low;
        int r = high;
        
        while (l != 0) {
            l /= 10;
            start++;
        }
        while (r != 0) {
            r /= 10;
            end++;
        }
        // System.out.println(start);
        // System.out.println(end);
        for (int i = start; i <= end; ++i) {
            helper(result, i, low, high);
        }
        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        return list;
    }
    
    private void helper(Set<Integer> result, int digits, int low, int high) {
        
        boolean flag = false;
        for (int start = 1; start <= 9; ++start) {
            if (flag) break;
            StringBuilder sb = new StringBuilder();
            int k = start;
            // System.out.println(start);
            for (int i = 0; i < digits; ++i) {
                if (k == 10) {
                    flag = true;
                    break;
                }
                sb.append(k + "");
                k++;
            }
            int cur = Integer.valueOf(sb.toString());
            // System.out.println(cur);
            if (cur >= low && cur <= high) {
                // System.out.println(cur);
                result.add(cur);
            }
        }
    }
}