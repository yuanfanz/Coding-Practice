class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        for (int i = 0; i < m; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }
        int[] groupIndegree = new int[m];
        int[] itemIndegree = new int[n];
        
        buildGroupGraph(groupGraph, groupIndegree, group, beforeItems, n);
        buildItemGraph(itemGraph, itemIndegree, beforeItems, n);
        
        List<Integer> groupList = topologicalSort(groupGraph, groupIndegree, m);
        List<Integer> itemList = topologicalSort(itemGraph, itemIndegree, n);
        
        if (groupList.size() == 0 || itemList.size() == 0) {
            return new int[0];
        }
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemList) {
            int curGroup = group[item];
            List<Integer> list = groupToItems.getOrDefault(curGroup, new ArrayList<>());
            list.add(item);
            groupToItems.put(curGroup, list);
        }
        int[] result = new int[n];
        int index = 0;
        for (int curGroup : groupList) {
            List<Integer> items = groupToItems.getOrDefault(curGroup, new ArrayList<>());
            for (int cur : items) {
                result[index++] = cur;
            }
        }
        return result;
    }
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree, int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int key : graph.keySet()) {
            if (indegree[key] == 0) {
                queue.offer(key);
            }
        }
        while (queue.size() > 0) {
            int cur = queue.poll();
            n--;
            result.add(cur);
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return n != 0 ? new ArrayList<>() : result;
    }
    private void buildItemGraph(Map<Integer, List<Integer>> itemGraph, int[] itemIndegree,
                                List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; ++i) {
            List<Integer> fromItems = beforeItems.get(i);
            for (int cur : fromItems) {
                List<Integer> itemList = itemGraph.getOrDefault(cur, new ArrayList<>());
                itemList.add(i);
                itemGraph.put(cur, itemList);
                itemIndegree[i]++;
            }
        }
    }
    private void buildGroupGraph(Map<Integer, List<Integer>> groupGraph, int[] groupIndegree,
                                int[] group, List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; ++i) {
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);
            for (int cur : fromItems) {
                int fromGroup = group[cur];
                if (fromGroup != toGroup) {
                    List<Integer> groupList = groupGraph.getOrDefault(fromGroup, new ArrayList<>());
                    groupList.add(toGroup);
                    groupGraph.put(fromGroup, groupList);
                    groupIndegree[toGroup]++;
                }
            }
        }
    }
}