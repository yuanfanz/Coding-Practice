class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        
        int[] presum = new int[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            presum[i] = presum[i - 1] + nums[i];
        }
        
        int mod = (int) Math.pow(10, 9) + 7;
        long res = 0;
        // the left subarray max should be total sum / 3
        int leftMax = presum[n - 1] / 3;
        for (int i = 0; i < n && presum[i] <= leftMax; ++i) {
            // 二分查找第二刀的最小值：presum(mid) == presum(left)
            // 在 [i+1, n] 中二分查找 presum[i] * 2，presum[i] 为到 i 为止元素和
            // 因为是前缀数组，因而应该查找 presum(left) + presum(mid)
            int left = findLeftBound(i + 1, presum, presum[i] * 2);
            int right = findRightBound(i + 1, presum, presum[i] + (presum[n - 1] - presum[i]) / 2);
            
            if (left == -1 || right == -1) continue;
            if (right >= left) {
                res += (right - left + 1);
            }
        }
        return (int) (res % mod);
    }
    
    private int findLeftBound(int i, int[] presum, int target) {
        int j = presum.length - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (presum[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= presum.length) return -1;
        return i;
    }
    
    private int findRightBound(int i, int[] presum, int target) {
        int j = presum.length - 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (presum[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0) return -1;
        return j;
    }
}