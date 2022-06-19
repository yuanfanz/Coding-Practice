class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 1; i <= 26; ++i) {
            max = Math.max(max, helper(s, k, i));
        }
        return max;
    }
    
    private int helper(String s, int k, int unique) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int curUnique = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            if (!map.containsKey(ch)) {
                curUnique++;
            }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (i < s.length() && curUnique > unique) {
                char cur = s.charAt(i++);
                int count = map.get(cur);
                if (--count > 0) {
                    map.put(cur, count);
                } else {
                    curUnique--;
                    map.remove(cur);
                }
            }
            if (curUnique <= unique && isValid(map, k)) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
    
    private boolean isValid(Map<Character, Integer> map, int k) {
        for (char ch : map.keySet()) {
            if (map.get(ch) < k) {
                return false;
            }
        }
        return true;
    }
}