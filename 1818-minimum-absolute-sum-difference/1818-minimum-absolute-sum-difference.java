class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) Math.pow(10, 9) + 7;
        
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long max = 0;
        long sum = 0;
        for (int i = 0; i < n; ++i){
            int a = nums1[i];
            int b = nums2[i];
            int diff = Math.abs(a - b);
            if (diff == 0) continue;
            sum = sum + diff;
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (sorted[mid] <= b) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (right < 0) right = 0;
            int newDiff = Math.abs(sorted[right] - b);
            if (right + 1 < n) newDiff = Math.min(newDiff, Math.abs(sorted[right + 1] - b));
            if (newDiff < diff) max = Math.max(max, diff - newDiff);
        }
        return (int) ((sum - max) % mod);
    }
}