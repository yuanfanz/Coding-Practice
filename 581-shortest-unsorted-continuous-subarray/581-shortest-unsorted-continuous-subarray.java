class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        int start = 0;
        int end = -1;
        int min = nums[n - 1];
        int max = nums[0];
        
        for (int i = 0; i < n; ++i) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] > min) {
                start = i;
            } else {
                min = nums[i];
            }
        }
        return end - start + 1;
    }
}