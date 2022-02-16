class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;     
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        /**
        A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
        B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
        */
        int mid = (m + n + 1) / 2;
        int min = 0;
        int max = m;
        while (min <= max) {
            int i = min + (max - min) / 2;
            int j = mid - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                // left is too big
                max = i - 1;
            } else if (i < m && nums1[i] < nums2[j - 1]) {
                // right is too big
                min = i + 1;
            } else {
                // left and right balanced
                int leftMax = Integer.MIN_VALUE;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }
                int rightMin = Integer.MAX_VALUE;
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (double) (leftMax + rightMin) / 2;
            }
        }
        return 0;
    }
}








