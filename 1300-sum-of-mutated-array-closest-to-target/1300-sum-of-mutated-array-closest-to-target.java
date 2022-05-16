class Solution {
    public int findBestValue(int[] arr, int target) {
        int i = 0;
        int j = 0;
        for (int x : arr) {
            j = Math.max(x, j);
        }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int sum = getSum(arr, mid);
            if (sum == target) {
                return mid;
            } else if (sum < target) { // value need to be larger
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        // now value could be i or i - 1
        int sum1 = getSum(arr, i);
        int sum2 = getSum(arr, i - 1);
        if (Math.abs(sum1 - target) < Math.abs(sum2 - target)) {
            return i;
        } else {
            return i - 1;
        }
    }
    
    private int getSum(int[] arr, int mid) {
        int sum = 0;
        for (int i : arr) {
            if (i > mid) {
                sum += mid;
            } else {
                sum += i;
            }
        }
        return sum;
    }
}