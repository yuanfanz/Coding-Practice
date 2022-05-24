class Solution {
    public int longestValidParentheses(String s) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                leftMax = Math.max(leftMax, left * 2);
            }
            if (right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ')') {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                rightMax = Math.max(rightMax, right * 2);
            }
            if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return Math.max(leftMax, rightMax);
    }
}