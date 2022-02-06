class Solution {
    public int splitArray(int[] nums, int m) {
        int i = 0;
        int j = nums.length * 1000000;
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
    private boolean isValid(int[] nums, int m, int max) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] > max) {
                return false;
            }
            int sum = 0;
            while (i < nums.length && sum + nums[i] <= max) {
                sum += nums[i++];
            }
            count++;
        }
        return count <= m;
    }
}