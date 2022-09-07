class Solution {
    public int longestNiceSubarray(int[] nums) {
        // int i = 0;
        // int or = 0;
        // int max = 0;
        // for (int j = 0; j < nums.length; ++j) {
        //     or = or | nums[j];
        //     while (i < nums.length && or != 0) {
        //         or = or ^ nums[i++];
        //     }
        //     max = Math.max(max, j - i + 1);
        // }
        // return max;
        int j = 0;
        int max = 0;
        int or = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && (or & nums[j]) == 0) {
                or = or | nums[j];
                j++;
            }
            max = Math.max(max, j - i);
            or = or ^ nums[i];
        }
        return max;
    }
}