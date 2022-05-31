class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        
        // for (int i = 0; i < 1 << k; ++i) {
        //     set.add(i);
        // }
        
        // Set<String> visited = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; ++i) {
            // if (set.size() == 0) return true;
            // String cur = ;
            // if (visited.contains(s.substring(i, i + k))) continue;
            set.add(s.substring(i, i + k));
            // int num = Integer.parseInt(s.substring(i, i + k), 2);
            
            // if (set.contains(num)) {
            //     set.remove(num);
            // }
        }
        return set.size() == (1 << k);
    }
}