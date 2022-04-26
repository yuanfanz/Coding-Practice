class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int i = 1;
        int j = 1000000001;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isValid(nums, mid, maxOperations)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
    
    private boolean isValid(int[] nums, int mid, int k) {
        int count = 0;
        for (int i : nums) {
            count += i / mid;
            if (i % mid == 0) {
                count--;
            }
        }
        return count <= k;
    }
}



















