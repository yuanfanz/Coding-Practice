class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        
        int[] result = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            int k = i + 1;
            while (k < n && temperatures[i] >= temperatures[k] && result[k] != 0) {
                k += result[k];
            }
            if (temperatures[i] < temperatures[k]) {
                result[i] = k - i;
            }
        }
        return result;
    }
}