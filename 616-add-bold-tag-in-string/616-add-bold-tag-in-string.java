class Solution {
    public String addBoldTag(String s, String[] words) {
        Map<Integer, String> map = new HashMap<>();
        
        boolean[] mask = new boolean[s.length()];
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        // printSet(set);
        for (int i = 0; i < s.length(); ++i) {
            String cur = checkStart(set, s, i);
            if (cur.length() > 0) {
                // System.out.println(cur);
                    // System.out.println(i + " ");
                for (int j = i; j < i + cur.length(); ++j) {
                    // System.out.print(j + " ");
                    mask[j] = true;
                }
            }
        }
        // print(mask);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < mask.length) {
            if (mask[i]) {
                sb.append("<b>");
                while (i < mask.length && mask[i]) {
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
    
    private String checkStart(Set<String> set, String s, int start) {
        String res = "";
        for (String cur : set) {
            if (s.startsWith(cur, start)) {
                // System.out.println(start);
                // System.out.println(cur);
                if (cur.length() > res.length()) {
                    res = cur;
                }
            }
        }
        return res;
    }
    
    private void print(boolean[] grid) {
        for (int i = 0; i < grid.length; ++i) {
            System.out.print(grid[i] + " ");
        }
        System.out.println();
    }
    
    private void printSet(Set<String> set) {
        for (String i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}










