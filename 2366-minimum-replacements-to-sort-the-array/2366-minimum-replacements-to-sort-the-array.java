class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        
        int prev = nums[nums.length - 1];
        
        for (int i = nums.length - 2; i >= 0; --i) {
            int cur = nums[i];
            if (cur > prev) {
                int k = (cur + prev - 1) / prev;
                res += k - 1;
                prev = cur / k;
            } else {
                prev = cur;
            }
        }
        return res;
        
    }
}