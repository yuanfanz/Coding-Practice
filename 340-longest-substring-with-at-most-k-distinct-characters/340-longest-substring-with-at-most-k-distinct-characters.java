class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int max = 0;
        int count = 0;
        for (int j = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            count++;
            while (i < s.length() && map.size() > k) {
                int freq = map.get(s.charAt(i));
                freq--;
                count--;
                if (freq == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), freq);
                }
                i++;
            }
            if (map.size() <= k) {
                max = Math.max(max, count);
            }
        }
        return max;
    }
}