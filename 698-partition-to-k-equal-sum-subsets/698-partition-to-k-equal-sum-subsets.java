class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (nums.length < k || sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, target, k, visited, nums.length - 1, 0);
    }
    private boolean dfs(int[] nums, int target, int k, boolean[] visited, int index, int sum) {
        if (k == 0) return true;
        if (sum == target && dfs(nums, target, k - 1, visited, nums.length - 1, 0)) {
            return true;
        }
        for (int i = index; i >= 0; --i) {
            if (!visited[i] && sum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, target, k, visited, i - 1, sum + nums[i])) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}