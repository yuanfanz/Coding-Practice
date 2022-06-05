class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        int n = nums.length;
        int max = 0;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == 0) {
                count++;
            }
            while (count > 1 && i < n) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }
            if (count <= 1) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}