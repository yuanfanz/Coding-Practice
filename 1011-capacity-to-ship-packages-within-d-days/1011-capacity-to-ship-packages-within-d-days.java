class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = 1;
        int j = weights.length * 500;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(weights, mid, days)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
    private boolean isValid(int[] weights, int mid, int days) {
        int i = 0;
        int count = 0;
        while (i < weights.length) {
            int sum = 0;
            if (weights[i] > mid) {
                return false;
            }
            while (i < weights.length && sum + weights[i] <= mid) {
                sum += weights[i++];
            }
            count++;
        }
        return count <= days;
    }
}