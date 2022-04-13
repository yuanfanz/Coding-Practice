class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int len = 1;
        int[] sequence = new int[n];
        sequence[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] <= sequence[len - 1]) {
                int index = search(sequence, nums[i], len - 1);
                sequence[index] = nums[i];
            } else {
                sequence[len++] = nums[i];
            }
        }
        return len;
    }
    
    private int search(int[] nums, int target, int end) {
        int i = 0;
        int j = end;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}