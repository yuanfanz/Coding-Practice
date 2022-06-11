class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total < x) return -1;
        int i = 0;
        int sum = 0;
        int target = total - x;
        int max = 0;
        boolean found = false;
            // System.out.println("target"+target);
        for (int j = 0; j < n; ++j) {
            sum += nums[j];
            while (i < n && sum > target) {
                sum -= nums[i];
                i++;
            }
            // System.out.println(sum);
            if (sum == target) {
                found = true;
                max = Math.max(max, j - i + 1);
            }
        }
        return found ? n - max : -1;
    }
}