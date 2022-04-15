class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int count = 0;
            for (int k = 0; k < nums.length; ++k) {
                if (nums[k] <= mid) {
                    count++;
                }
            }
            // count should equals mid
            if (count <= mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}