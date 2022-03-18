class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int index = n - 1;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;
        
        while (i <= j) {
            int num = 0;
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                num = nums[i];
                i++;
            } else {
                num = nums[j];
                j--;
            }
            result[index--] = num * num;
        }
        return result;
    }
}