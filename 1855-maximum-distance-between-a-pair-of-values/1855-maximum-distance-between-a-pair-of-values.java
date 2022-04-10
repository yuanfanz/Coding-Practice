class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int range = 0;
        for (int j = nums2.length - 1; j >= 0; --j) {
            int target = nums2[j];
            int left = 0;
            int right = nums1.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[mid] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // if (right < 0 || nums1[right] <= target) {
            //     right = -1;
            // }
            // if (right != -1) {
            //     range = Math.max(range, j - (right + 1));
            // }
            if (left >= nums1.length || nums1[left] > target) {
                left = -1;
            }
            if (left != -1) {
                range = Math.max(range, j - left);
            }
        }
        return range;
    }
}