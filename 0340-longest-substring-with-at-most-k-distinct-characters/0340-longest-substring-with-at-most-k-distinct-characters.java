class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            
            while (i < s.length() && map.size() > k) {
                char ch = s.charAt(i++);
                int val = map.get(ch);
                val--;
                if (val > 0) {
                    map.put(ch, val);
                } else {
                    map.remove(ch);
                }
            }
            if (map.size() <= k) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}