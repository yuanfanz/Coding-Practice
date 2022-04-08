class Solution {
    public int getMaxLen(int[] nums) {
        int neg = 0;
        int pos = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                neg = 0;
                pos = 0;
            } else if (nums[i] > 0) {
                pos++;
                neg = neg > 0 ? neg + 1 : 0;
            } else if (nums[i] < 0) {
                // negtive number
                // pos > 0: neg = pos + 1
                // neg > 0: pos = neg + 1
                int tmp = pos;
                pos = neg > 0 ? neg + 1 : 0;
                neg = tmp > 0 ? tmp + 1 : 1;
            }
            max = Math.max(pos, max);
        }
        return max;
    }
}