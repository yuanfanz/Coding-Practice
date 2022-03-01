class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (i < s.length() && map.size() > 2) {
                int count = map.get(s.charAt(i));
                count--;
                if (count == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), count);
                }
                i++;
            }
            if (map.size() <= 2) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}