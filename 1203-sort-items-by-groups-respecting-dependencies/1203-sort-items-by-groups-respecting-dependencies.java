class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        
        for (int i = 0; i < group.length; ++i) {
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
            System.out.println("YES");
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
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // for (int key : graph.keySet()) {
        //     if (indegree[key] == 0) {
        //         queue.offer(key);
        //     }
        // }
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
    private void buildGroupGraph(Map<Integer, List<Integer>> groupGraph, int[] groupIndegree,
                                int[] group, List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; ++i) {
            int toGroup = group[i];
            for (int prev : beforeItems.get(i)) {
                int fromGroup = group[prev];
                if (fromGroup != toGroup) {
                    List<Integer> list = groupGraph.getOrDefault(fromGroup, new ArrayList<>());
                    list.add(toGroup);
                    groupGraph.put(fromGroup, list);
                    groupIndegree[toGroup]++;
                }
            }
        }
    }
    private void buildItemGraph(Map<Integer, List<Integer>> itemGraph, int[] itemIndegree,
                                List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; ++i) {
            for (int prev : beforeItems.get(i)) {
                List<Integer> list = itemGraph.getOrDefault(prev, new ArrayList<>());
                list.add(i);
                itemGraph.put(prev, list);
                itemIndegree[i]++;
            }
        }
    }
}