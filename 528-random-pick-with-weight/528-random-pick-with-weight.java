class Solution {
    private int[] wSum;
    public Solution(int[] w) {
        int n = w.length;
        wSum = new int[n];
        wSum[0] = w[0];
        for (int i = 1; i < n; ++i) {
            wSum[i] = wSum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int index = random.nextInt(wSum[wSum.length - 1]) + 1;
        
        int i = 0;
        int j = wSum.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (wSum[mid] == index) {
                return mid;
            } else if (wSum[mid] > index) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */