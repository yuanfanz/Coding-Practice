class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            int value = nums1[i];
            int index = -1;
            for (int j = 0; j < nums2.length; ++j) {
                if (nums2[j] != value) continue;
                while (j < nums2.length) {
                    if (nums2[j] > value) {
                        index = nums2[j];
                        break;
                    }
                    j++;
                }
            }
            result[i] = index;
        }
        return result;
    }
}