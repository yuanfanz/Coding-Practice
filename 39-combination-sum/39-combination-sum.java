class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        dfs(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                     int[] candidates, int target, int index, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            list.add(candidates[i]);
            dfs(result, list, candidates, target, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}