class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            int index = i - count;
            if (index % 2 == 0) {
                if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    count++;
                }
            }
        }
        return count + (nums.length - count) % 2;
    }
}