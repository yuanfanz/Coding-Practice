class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n + 1];
        int len = 1;
        dp[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (dp[len - 1] >= nums[i]) {
                int index = find(dp, nums[i], 0, len - 1);
                dp[index] = nums[i];
            } else {
                dp[len++] = nums[i];
            }
        }
        return len;
    }
    private int find(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}