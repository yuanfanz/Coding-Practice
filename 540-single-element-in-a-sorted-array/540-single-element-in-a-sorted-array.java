class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return nums[i];
    }
}