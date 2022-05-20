class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, 
                     int index, int n, int k) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; ++i) {
            list.add(i);
            dfs(result, list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}