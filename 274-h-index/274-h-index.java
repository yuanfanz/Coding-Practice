class Solution {
    public int hIndex(int[] citations) {
        int i = 0;
        int j = 1001;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (isValid(citations, mid)) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    private boolean isValid(int[] citations, int mid) {
        int count = 0;
        
        for (int i : citations) {
            if (i >= mid) {
                count++;
            }
        }
        return count >= mid;
    }
}