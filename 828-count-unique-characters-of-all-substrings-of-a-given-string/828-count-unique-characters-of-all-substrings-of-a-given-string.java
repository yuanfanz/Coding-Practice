class Solution {
    public int uniqueLetterString(String s) {
        int[] contribution = new int[26];
        int[] lastPosition = new int[26];
        
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            int charNum = s.charAt(i) - 'A';
            
            int totalEndingHere = i + 1;
            contribution[charNum] = totalEndingHere - lastPosition[charNum];
            
            int cur = 0;
            for (int j = 0; j < 26; ++j) {
                cur += contribution[j];
            }
            res += cur;
            lastPosition[charNum] = i + 1;
        }
        return res;
    }
}