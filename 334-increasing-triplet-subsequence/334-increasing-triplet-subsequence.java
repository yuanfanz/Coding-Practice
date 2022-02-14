class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int[] sequence = new int[n];
        int len = 0;
        sequence[len++] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > sequence[len - 1]) {
                sequence[len++] = nums[i];
                if (len >= 3) return true;
            } else {
                int index = findFirstPosition(sequence, 0, len - 1, nums[i]);
                sequence[index] = nums[i];
            }
        }
        return false;
    }
    
    private int findFirstPosition(int[] nums, int i, int j, int target) {
        while (i <= j){
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