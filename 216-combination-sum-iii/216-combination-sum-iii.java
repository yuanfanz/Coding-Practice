class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, 0, k, n);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int cur, int sum, int k, int n) {
        if (list.size() > k || sum > n) {
            return;
        }
        if (list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
        }
        for (int i = cur; i <= 9; ++i) {
            list.add(i);
            dfs(result, list, i + 1, sum + i, k, n);
            list.remove(list.size() - 1);
        }
    }
}