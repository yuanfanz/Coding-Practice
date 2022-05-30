class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(candidates, result, new ArrayList<>(), target, 0, 0);
        return result;
    }
    
    private void dfs(int[] candidates, List<List<Integer>> result, 
                     List<Integer> list, int target, int index, int sum) {
        if (sum > target) return;
        if (index == candidates.length) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            list.add(candidates[i]);
            dfs(candidates, result, list, target, i, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}