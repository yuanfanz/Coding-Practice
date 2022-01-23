class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 1;
        String[] result = new String[1];
        for (int i = 1; i < s.length(); ++i) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == s.charAt(i)) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len >= max) {
                max = len;
                result[0] = s.substring(left + 1, right);
            }
        }
        return result[0];
    }
}