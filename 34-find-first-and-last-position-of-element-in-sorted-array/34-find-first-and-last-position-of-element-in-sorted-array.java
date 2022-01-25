class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        int[] result = new int[2];
        // find first
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                j = mid - 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        result[0] = i;
        if (i >= nums.length || nums[i] != target) {
            result[0] = -1;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        result[1] = j;
        if (j < 0 || nums[j] != target) {
            result[1] = -1;
        }
        return result;
    }
}