class Solution {
    public int jump(int[] nums) {
        int curEnd = 0;
        int max = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            max = Math.max(max, i + nums[i]);
            if (curEnd == i) {
                jumps++;
                curEnd = max;
            }
        }
        return jumps;
    }
}