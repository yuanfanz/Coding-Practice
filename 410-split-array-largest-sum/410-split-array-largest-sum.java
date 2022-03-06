class Solution {
    public int splitArray(int[] nums, int m) {
        int i = 0;
        int j = nums.length * 1000000;
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(nums, mid, m)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
    private boolean isValid(int[] nums, int mid, int m) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            int sum = 0;
            if (nums[i] > mid) {
                return false;
            }
            while (i < nums.length && sum + nums[i] <= mid) {
                sum += nums[i++];
            }
            count++;
        }
        return count <= m;
    }
}