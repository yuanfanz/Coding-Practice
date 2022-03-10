class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(result, list, graph, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int[][] graph, int index) {
        if (index == graph.length - 1) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int next : graph[index]) {
            list.add(next);
            dfs(result, list, graph, next);
            list.remove(list.size() - 1);
        }
    }
}