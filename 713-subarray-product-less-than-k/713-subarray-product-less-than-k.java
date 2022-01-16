class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j = 0;
        int product = 1;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            product *= nums[i];
            while (j <= i && product >= k) {
                product /= nums[j++];
            }
            count += i - j + 1;
        }
        return count;
    }
}