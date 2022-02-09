class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String[] result = new String[1];
        result[0] = "";
        for (int i = 0; i < s.length(); ++i) {
            int left = i;
            int right = i;
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
            if (right - left > max) {
                max = right - left - 1;
                result[0] = s.substring(left + 1, right);
            }
        }
        return result[0];
    }
}