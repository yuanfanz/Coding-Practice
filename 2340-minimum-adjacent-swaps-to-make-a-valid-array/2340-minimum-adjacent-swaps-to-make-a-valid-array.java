class Solution {
    public int minimumSwaps(int[] nums) {
        int max = nums[0];
        int min = nums[nums.length - 1];
        int lastMax = 0;
        int firstMin = nums.length - 1;
        
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] >= max) {
                max = nums[i];
                lastMax = i;
            }
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            if (nums[i] <= min) {
                min = nums[i];
                firstMin = i;
            }
        }
        int count = 0;
        // System.out.println("lastMax: " + lastMax);
        count += nums.length - lastMax - 1;
        // System.out.println("count: " + count);
        count += firstMin;
        // System.out.println("count: " + count);
        
        if (firstMin > lastMax) count--;
        return count;
    }
}