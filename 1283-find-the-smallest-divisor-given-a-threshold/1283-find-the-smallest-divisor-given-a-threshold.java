class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1;
        int j = 1000001;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(nums, mid, threshold)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
    
    private boolean isValid(int[] nums, int divisor, int threshold) {
        int count = 0;
        for (int i : nums) {
            count += i / divisor;
            if (i % divisor != 0) {
                count++;
            }
        }
        return count <= threshold;
    }
}