class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i = 0;
        int j = weights.length * 500;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(weights, days, mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
    private boolean isValid(int[] weights, int days, int cap) {
        int count = 0;
        int i = 0;
        
        while (i < weights.length) {
            if (weights[i] > cap) {
                return false;
            }
            int sum = 0;
            while (i < weights.length && sum + weights[i] <= cap) {
                sum += weights[i++];
            }
            count++;
        }
        return count <= days;
    }
}