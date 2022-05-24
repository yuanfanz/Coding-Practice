class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k == 0) return getSubArr(nums, 0);
        
        return getSubArr(nums, k) - getSubArr(nums, k - 1);
    }
    
    private int getSubArr(int[] nums, int k) {
        int i = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if (nums[j] % 2 == 1) {
                sum++;
            }
            while (i < n && sum > k) {
                if (nums[i] % 2 == 1) {
                    sum--;
                }
                i++;
            }
            if (sum <= k) {
                count += j - i + 1;
            }
        }
        return count;
    }
}