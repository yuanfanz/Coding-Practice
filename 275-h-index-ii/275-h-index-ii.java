class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            
            // (n - mid) means the total number of paper higher than h
            if (citations[mid] >= n - mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return n - i;
    }
}