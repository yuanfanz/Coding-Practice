class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        String[] result = new String[1];
        result[0] = s.charAt(0) + "";
        for (int i = 0; i < s.length(); ++i) {
            int left = i - 1;
            int right = i + 1;
            char ch = s.charAt(i);
            while (left >= 0 && s.charAt(left) == ch) {
                left--;
            }
            while (right < s.length() && s.charAt(right) == ch) {
                right++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 >= max) {
                max = right - left - 1;
                result[0] = s.substring(left + 1, right);
            }
        }
        return result[0];
    }
}