class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        int max = 0;
        int onesInWindow = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            ones += nums[i];
        }
        int[] nums2 = new int[n * 2];
        for (int i = 0; i < n * 2; ++i) {
            nums2[i] = nums[i % n];
        }
        for (int i = 0; i < n * 2; ++i) {
            if (i >= ones && nums2[i - ones] == 1) {
                max--;
            }
            if (nums2[i] == 1) {
                max++;
            }
            onesInWindow = Math.max(max, onesInWindow);
        }
        return ones - onesInWindow;
    }
}