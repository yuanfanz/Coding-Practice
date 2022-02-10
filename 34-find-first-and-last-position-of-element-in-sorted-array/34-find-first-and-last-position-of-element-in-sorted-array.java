class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        
        int[] result = new int[2];
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (i >= nums.length || nums[i] != target) {
            i = -1;
        }
        result[0]= i;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0 || nums[j] != target) {
            j = -1;
        }
        result[1] = j;
        return result;
    }
}