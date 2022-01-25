class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int ones = 0;
        int[] arr = new int[2*n];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = nums[i % n];
            if (arr[i] == 1) {
                ones++;
            }
        }
        ones = ones / 2;
        int j = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; ++i) {
            while (j < arr.length && j - i + 1 <= ones) {
                if (arr[j++] == 1) {
                    count++;
                }
            }
            max = Math.max(max, count);
            if (arr[i] == 1) {
                count--;
            }
        }
        return ones - max;
    }
}