class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // nums1: 1 2 3 4 ....i - 1 | i, ... m - 1
        // nums2: 1 2 3 4 ....j - 1 | j, ... n - 1
        int mid = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = mid - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else if (i < m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
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

