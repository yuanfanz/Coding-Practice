class Solution {
    public int missingElement(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int first = nums[0];
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int missing = nums[mid] - first - mid;
            if (missing >= k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return first + i + k - 1;
    }
}