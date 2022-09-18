class Solution {
    public int longestContinuousSubstring(String s) {
        int i = 0;
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.length(); ++j) {
            sb.append(s.charAt(j));
            while (i < s.length() && !isValid(sb.toString())) {
                sb.deleteCharAt(0);
                i++;
            }
            if (isValid(sb.toString())) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
    
    private boolean isValid(String s) {
        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) - 'a' != s.charAt(i + 1) - 'a' - 1) {
                return false;
            }
        }
        return true;
    }
}