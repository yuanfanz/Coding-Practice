class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        int max = 0;
        String[] result = new String[1];
        result[0] = "";
        for (int i = 0; i < s.length(); ++i) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) left--;
            while (right < n && s.charAt(right) == s.charAt(i)) right++;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len = right - left - 1;
            if (len > max) {
                max = len;
                result[0] = s.substring(left + 1, right);
            }
        }
        return result[0];
    }
}