class Solution {
    public int[] searchRange(int[] nums, int target) {
        // if (nums.length == 0) {
        //     return new int[]{-1, -1};
        // }
        int[] result = new int[2];
        int first = findFirstPosition(nums, target);
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }
        result[0] = first;
        result[1] = findFirstPosition(nums, target + 1) - 1;
        return result;
    }
    private int findFirstPosition(int[] nums, int target) {
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}