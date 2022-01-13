class Solution {
    public int maxLength(int[] ribbons, int k) {
        int i = 1;
        int j = 100001;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(ribbons, mid, k)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;
    }
    private boolean isValid(int[] ribbons, int length, int k) {
        int count = 0;
        for (int i = 0; i < ribbons.length; ++i) {
            count += ribbons[i] / length;
        }
        return count >= k;
    }
}