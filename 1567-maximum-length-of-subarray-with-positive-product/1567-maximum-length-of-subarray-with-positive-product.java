class Solution {
    public int getMaxLen(int[] nums) {
        int product = 1;
        
        int positive = 0;
        int negative = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                positive = 0;
                negative = 0;
            } else if (nums[i] > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative + 1;
            } else {
                int tmp = positive;
                positive = negative == 0 ? 0 : negative + 1;
                negative = tmp + 1;
            }
            max = Math.max(positive, max);
        }
        return max;
    }
}