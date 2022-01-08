class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 1;
        int max = 1;
        set.add(s.charAt(0));
        while (i <= j && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                max = Math.max(max, (j - i + 1));
                j++;
            }
        }
        return max;
    }
}