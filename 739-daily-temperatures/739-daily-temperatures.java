class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        
        int[] result = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            int k = i + 1;
            while (k < n && nums[i] >= nums[k] && result[k] != 0) {
                k += result[k];
            }
            if (nums[i] < nums[k]) {
                result[i] = k - i;
            }
        }
        return result;
    }
}