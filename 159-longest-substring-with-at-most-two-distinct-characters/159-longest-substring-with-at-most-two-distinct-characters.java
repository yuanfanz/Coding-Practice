class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int max = 0;
        int i = 0;
        for (int j = 0; j < s.length(); ++j) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (i < s.length() && map.size() > 2) {
                char prev = s.charAt(i);
                int val = map.get(prev);
                val--;
                if (val > 0) {
                    map.put(prev, val);
                } else {
                    map.remove(prev);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}