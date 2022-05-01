class Solution {
    public long appealSum(String s) {
        long sum = 0;
        int[] lastPosition = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            lastPosition[s.charAt(i) - 'a'] = i + 1;
            for (int j : lastPosition) {
                sum += j;
            }
        }
        return sum;
    }
}