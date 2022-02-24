class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (i < s.length() && map.size() > k) {
                char cur = s.charAt(i++);
                int count = map.get(cur);
                if (--count > 0) {
                    map.put(cur, count);
                } else {
                    map.remove(cur);
                }
            }
            if (map.size() <= k) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}