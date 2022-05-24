class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (goal == 0) {
            return getSubArr(nums, 0);
        }
        return getSubArr(nums, goal) - getSubArr(nums, goal - 1);
    }
    
    // calculate the subarray number that sum less or equal to k
    private int getSubArr(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for (int j = 0; j < n; ++j) {
            sum += nums[j];
            while (i < n && sum > k) {
                sum -= nums[i];
                i++;
            }
            if (sum <= k) {
                res += j - i + 1;
            }
        }
        return res;
    }
}