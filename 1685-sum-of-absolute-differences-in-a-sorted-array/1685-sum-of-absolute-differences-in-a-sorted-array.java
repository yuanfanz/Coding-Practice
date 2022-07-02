class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = left[i - 1] + i * (nums[i] - nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; --i) {
            right[i] = right[i + 1] + (n - i - 1) * (nums[i + 1] - nums[i]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}