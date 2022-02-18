class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(result, new ArrayList<>(), n, 2);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int n, int index) {
        if (n == 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
                dfs(result, list, n/i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}