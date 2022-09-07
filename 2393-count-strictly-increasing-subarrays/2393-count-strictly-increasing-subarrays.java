class Solution {
    public long countSubarrays(int[] nums) {
        long res = 0;
        long cur = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > prev) {
                // System.out.println("cur: " + cur);
                res += cur;
                cur++;
                // System.out.println("res: " + res);
            } else {
                cur = 1;
            }
            prev = nums[i];
        }
        return res + nums.length;
    }
}