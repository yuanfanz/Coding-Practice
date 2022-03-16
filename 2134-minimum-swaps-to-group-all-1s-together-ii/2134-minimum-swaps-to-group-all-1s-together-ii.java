class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int[] arr = new int[n * 2];
        for (int i = 0; i < n * 2; ++i) {
            arr[i] = nums[i % n];
        }
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        int j = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; ++i) {
            while (j < arr.length && j - i + 1 <= total) {
                if (arr[j++] == 1) {
                    count++;
                }
            }
            max = Math.max(max, count);
            if (arr[i] == 1) {
                count--;
            }
        }
        return total - max;
    }
}