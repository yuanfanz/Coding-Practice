class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        
        return dfs(0, 0, pattern, s, map, new HashSet<>());
    }
    
    private boolean dfs(int i, int j, String pattern, String s, 
                        Map<Character, String> map, Set<String> set) {
        if (i == pattern.length()) {
            if (j == s.length()) {
                return true;
            } else {
                return false;
            }
        }
        if (map.containsKey(pattern.charAt(i))) {
            String cur = map.get(pattern.charAt(i));
            if (j + cur.length() <= s.length() && s.substring(j, j + cur.length()).equals(cur)) {
                return dfs(i + 1, j + cur.length(), pattern, s, map, set);
            } else {
                return false;
            }
        } 
        else {
            for (int k = j + 1; k <= s.length(); ++k) {
                String str = s.substring(j, k);
                if (!set.contains(str)) {
                    set.add(str);
                    map.put(pattern.charAt(i), str);
                    if (dfs(i + 1, k, pattern, s, map, set)) {
                        return true;
                    }
                    map.remove(pattern.charAt(i));
                    set.remove(str);
                }
            }
        }
        return false;
    }
}