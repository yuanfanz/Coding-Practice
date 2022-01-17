class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int ones = 0;
        for (int i = 0; i < n; ++i) {
            ones += nums[i];
        }
        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; ++i) {
            arr[i] = nums[i % n];
        }
        int j = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < n * 2; ++i) {
            while (j < n * 2 && j < i + ones) {
                count += arr[j++];
            }
            max = Math.max(max, count);
            count -= arr[i];
        }
        return ones - max;
    }
}