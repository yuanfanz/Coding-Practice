class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; ++k) {
            if (nums[k] < 0) {
                neg[j++] = nums[k];
            } else {
                pos[i++] = nums[k];
            }
        }
        int[] result = new int[n];
        int index = 0;
        i = 0;
        j = 0;
        while (index < n) {
            if (index % 2 == 1) {
                result[index++] = neg[j++];
            } else {
                result[index++] = pos[i++];
            }
        }
        return result;
    }
}