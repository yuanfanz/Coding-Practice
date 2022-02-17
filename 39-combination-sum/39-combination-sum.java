class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int[] nums, int target, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(result, list, nums, target, sum + nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}