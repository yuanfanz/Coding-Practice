class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int jump = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i > max) return -1;
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                jump++;
                end = max;
            }
        }
        return jump;
    }
}