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
    
    private boolean isValid(int[] citations, int h) {
        int i = 0;
        int j = citations.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (citations[mid] >= h) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= citations.length) return false;
        return citations.length - i >= h;
    }
}