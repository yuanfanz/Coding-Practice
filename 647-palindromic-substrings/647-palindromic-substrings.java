class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        
        boolean[][] isPalin = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < s.length(); ++j) {
            for (int i = 0; i <= j; ++i) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 > j - 1 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j]= isPalin[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}