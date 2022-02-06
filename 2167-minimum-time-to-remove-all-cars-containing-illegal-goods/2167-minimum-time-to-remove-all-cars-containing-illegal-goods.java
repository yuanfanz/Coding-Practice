class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            left = Math.min(left + (s.charAt(i) - '0') * 2, i + 1);
            min = Math.min(min, left + n - i - 1);
        }
        return min;
    }
}