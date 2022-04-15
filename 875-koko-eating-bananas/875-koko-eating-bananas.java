class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = (int) Math.pow(10, 9);
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(piles, mid, h)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
    
    private boolean isValid(int[] nums, int mid, int h) {
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            count += nums[i] / mid;
            if (nums[i] % mid != 0) {
                count++;
            }
        }
        return count <= h;
    }
}