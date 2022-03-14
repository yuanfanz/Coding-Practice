class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree = new int[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
        }
        for (int[] cur : roads) {
            int p = cur[0];
            int q = cur[1];
            indegree[p]++;
            indegree[q]++;
            List<Integer> list1 = map.get(p);
            List<Integer> list2 = map.get(q);
            list1.add(q);
            list2.add(p);
            map.put(p, list1);
            map.put(q, list2);
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int count = indegree[i] + indegree[j];
                if (map.get(i).contains(j)) count--;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}