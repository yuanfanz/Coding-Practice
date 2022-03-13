class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        
        int[] indegree = new int[n];
        for (List<Integer> list : edges) {
            int first = list.get(0);
            int second = list.get(1);
            indegree[second]++;
        }
        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}