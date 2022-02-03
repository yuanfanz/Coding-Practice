class Solution {
    public int splitArray(int[] nums, int m) {
        int i = 0;
        int j = 1000000000;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(nums, m, mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
    private boolean isValid(int[] nums, int m, int target) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            int sum = 0;
            if (nums[i] > target) {
                return false;
            }
            while (i < nums.length && sum + nums[i] <= target) {
                sum += nums[i++];
            }
            count++;
        }
        return count <= m;
    }
}