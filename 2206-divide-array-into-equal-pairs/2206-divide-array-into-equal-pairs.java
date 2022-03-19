class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ) {
            if (nums[i] != nums[i - 1]) {
                return false;
            }
            i+=2;
        }
        return true;
    }
}