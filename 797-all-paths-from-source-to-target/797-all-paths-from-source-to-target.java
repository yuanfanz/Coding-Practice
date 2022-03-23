class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(result, list, graph, 0, n);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, 
                     int[][] graph, int index, int n) {
        if (index == n - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[index]) {
            list.add(next);
            dfs(result, list, graph, next, n);
            list.remove(list.size() - 1);
        }
    }
}