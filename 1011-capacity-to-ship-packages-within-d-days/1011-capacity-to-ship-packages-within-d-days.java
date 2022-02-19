class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = 0;
        int j = 500 * weights.length;
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
    private boolean isValid(int[] weights, int cap, int days) {
        int count = 0;
        int i = 0;
        while (i < weights.length) {
            if (weights[i] > cap) return false;
            int sum = 0;
            while (i < weights.length && sum + weights[i] <= cap) {
                sum += weights[i++];
            }
            count++;
        }
        return count <= days;
    }
}