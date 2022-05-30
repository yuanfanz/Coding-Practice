class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates, result, visited, new ArrayList<>(), target, 0, 0);
        return result;
    }
    
    private void dfs(int[] candidates, List<List<Integer>> result, boolean[] visited,
                     List<Integer> list, int target, int index, int sum) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (visited[i] || (i > 0 && !visited[i - 1] && candidates[i] == candidates[i - 1])) continue;
            list.add(candidates[i]);
            visited[i] = true;
            dfs(candidates, result, visited, list, target, i + 1, sum + candidates[i]);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}