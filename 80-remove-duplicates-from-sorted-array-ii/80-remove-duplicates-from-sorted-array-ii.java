class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 2;
        for (int j = 2; j < nums.length; ++j) {
            // if duplicate more than twice, continue
            if (nums[j] == nums[i - 1] && nums[j] == nums[i - 2]) continue;
            nums[i++] = nums[j];
        }
        return i;
    }
}