class Solution {
    public long subArrayRanges(int[] nums) {
        
        long res = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; ++i) {
            long min = (long) nums[i];
            long max = (long) nums[i];
            for (int j = i + 1; j < n; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += (max - min);
            }
        }
        return res;
    }
}