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
        int count = 0;
        int max = 0;
        int i = 0;
        for (int j = 0; j < arr.length; ++j) {
            if (arr[j] == 1) {
                count++;
            }
            while (i < arr.length && j - i + 1 > total) {
                if (arr[i++] == 1) {
                    count--;
                }
            }
            if (j - i + 1 == total) {
                max = Math.max(max, count);
            }
        }
        return total - max;
    }
}