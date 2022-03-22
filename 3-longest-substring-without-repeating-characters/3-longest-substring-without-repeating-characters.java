class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int j = 0;
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            while (j < s.length() && !set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            if (j - i > max) {
                max = j - i;
            }
            set.remove(s.charAt(i));
        }
        return max;
    }
}