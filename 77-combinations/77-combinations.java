class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(result, new ArrayList<>(), n, k, 1);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; ++i) {
            // if (list.contains(i)) continue;
            list.add(i);
            dfs(result, list, n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}