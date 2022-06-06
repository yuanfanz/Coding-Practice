class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] seq = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
        }
        // dp find LIS
        for (int i = 0; i < n; ++i) {
            int len = 1;
            int prev = i;
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev = j;
                    }
                }
            }
            seq[i] = prev;
        }
        // find max
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > max) {
                index = i;
                max = dp[i];
            }
        }
        // find actual sequence
        List<Integer> result = new ArrayList<>();
        while (result.size() < max) {
            result.add(nums[index]);
            index = seq[index];
        }
        return result;
    }
}