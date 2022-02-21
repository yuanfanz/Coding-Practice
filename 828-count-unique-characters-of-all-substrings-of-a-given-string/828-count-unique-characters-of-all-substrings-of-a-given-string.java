class Solution {
    public int uniqueLetterString(String s) {
        int[] lastPosition = new int[128];
        int[] contribution = new int[128];
        
        int cur = 0;
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            cur -= contribution[ch];
            contribution[ch] = i - (lastPosition[ch] - 1);
            cur += contribution[ch];
            lastPosition[ch] = i + 1;
            res += cur;
        }
        return res;
    }
}