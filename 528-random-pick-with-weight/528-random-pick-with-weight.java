class Solution {
    int[] wSum;
    public Solution(int[] w) {
        int n = w.length;
        wSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            wSum[i + 1] = wSum[i] + w[i];
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int total = wSum[wSum.length - 1];
        int index = random.nextInt(total) + 1;
        
        int i = 1;
        int j = wSum.length;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (wSum[mid] == index) {
                return mid - 1;
            } else if (wSum[mid] < index) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */