class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int zeroes = 0;
        int max = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] == 0) {
                zeroes++;
            }
            while (i < nums.length && zeroes > k) {
                if (nums[i++] == 0) {
                    zeroes--;
                }
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}