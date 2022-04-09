class Solution {
    public int specialArray(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <= nums[len - 1]; ++i) {
            int index = findFirstIndexGreaterOrEqualTo(i, nums);
            if (len - index == i) {
                return i;
            }
        }
        return -1;
    }
    private int findFirstIndexGreaterOrEqualTo(int target, int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= nums.length || nums[i] < target) {
            return -1;
        }
        return i;
    }
}