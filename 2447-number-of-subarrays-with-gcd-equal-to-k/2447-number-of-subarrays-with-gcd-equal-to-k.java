class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            int currgcd = nums[i];
            if (currgcd == k) {
                res++;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                // if nums[j] < k gcd can never be equal to k for this subarray
                if (nums[j] < k) break;
                currgcd = gcd(nums[j], currgcd);
                if (currgcd == k) res++;
            }
        }
        return res;
    }
    
    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}