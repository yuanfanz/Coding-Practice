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
    private boolean isValid(int[] nums, int cap, int m) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] > cap) return false;
            int sum = 0;
            while (i < nums.length && sum + nums[i] <= cap) {
                sum += nums[i++];
            }
            count++;
        }
        return count <= m;
    }
}