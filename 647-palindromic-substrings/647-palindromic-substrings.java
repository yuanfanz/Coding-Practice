class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        boolean[][] isPalin = new boolean[n][n];
        
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || isPalin[j + 1][i - 1])) {
                    isPalin[i][j] = isPalin[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}