class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int[] diff1 = new int[n];
        int[] diff2 = new int[n];
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; ++i) {
            diff1[i] = nums2[i] - nums1[i];
            diff2[i] = nums1[i] - nums2[i];
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        
        int max1 = getMax(diff1, n);
        int max2 = getMax(diff2, n);
        
        return Math.max(sum1 + max1, sum2 + max2);
    }
    
    private int getMax(int[] diff, int n) {
        int[] presum = new int[n];
        presum[0] = diff[0];
        int max = diff[0];
        for (int i = 1; i < n; ++i) {
            presum[i] = diff[i] + (presum[i - 1] > 0 ? presum[i - 1] : 0);
            max = Math.max(max, presum[i]);
        }
        return max;
    }
}