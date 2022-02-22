class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dfs(nums, 0, 0, target, new HashMap<>());
    }
    private int dfs(int[] nums, int sum, int index, int target, Map<String, Integer> map) {
        String key = index + "->" + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int cur = nums[index];
        int minus = dfs(nums, sum - cur, index + 1, target, map);
        int plus = dfs(nums, sum + cur, index + 1, target, map);
        map.put(key, minus + plus);
        return minus + plus;
    }
}