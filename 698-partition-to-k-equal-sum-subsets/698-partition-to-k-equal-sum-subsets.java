class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, target, k, 0, nums.length - 1, visited);
    }
    private boolean dfs(int[] nums, int target, int k, int sum, int index, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (sum == target && dfs(nums, target, k - 1, 0, nums.length - 1, visited)) {
            return true;
        }
        for (int i = index; i >= 0; --i) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, target, k, sum + nums[i], i - 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}