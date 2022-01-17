class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), k, n, 0, 1);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int k, int n, int sum, int index) {
        if (list.size() > k || sum > n) {
            return;
        }
        if (list.size() == k && sum == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < 10; ++i) {
            if (list.contains(i)) continue;
            list.add(i);
            dfs(result, list, k, n, sum + i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}