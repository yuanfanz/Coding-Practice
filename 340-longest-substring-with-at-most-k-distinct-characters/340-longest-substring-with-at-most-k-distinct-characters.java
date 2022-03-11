class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        
        int i = 0;
        int count = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            count++;
            while (i < s.length() && map.size() > k) {
                int val = map.get(s.charAt(i));
                val--;
                if (val == 0) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), val);
                }
                count--;
                i++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}