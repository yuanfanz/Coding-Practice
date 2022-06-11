class Solution {
    public long countSubarrays(int[] nums, long k) {
        int i = 0;
        int n = nums.length;
        long sum = 0;
        long count = 0;
        for (int j = 0; j < n; ++j) {
            sum += nums[j];
            while (sum * (j - i + 1) >= k) {
                sum -= nums[i++];
            }
            if (sum < k) {
                count += (j - i + 1);
            }
        }
        return count;
    }
}

















