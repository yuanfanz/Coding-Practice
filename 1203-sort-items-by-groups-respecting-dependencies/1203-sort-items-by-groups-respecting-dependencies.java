class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        Map<Integer, List<Integer>> itemMap = new HashMap<>();
        
        for (int i = 0; i < group.length; ++i) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        for (int i = 0; i < m; ++i) {
            groupMap.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; ++i) {
            itemMap.put(i, new ArrayList<>());
        }
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];
        
        buildGroupGraph(groupMap, groupIndegree, beforeItems, group, n);
        buildItemGraph(itemMap, itemIndegree, beforeItems, n);
        
        List<Integer> groupList = topologicalSort(groupIndegree, groupMap, m);
        List<Integer> itemList = topologicalSort(itemIndegree, itemMap, n);
        
        if (groupList.size() == 0 || itemList.size() == 0) {
            return new int[0];
        }
        
        Map<Integer, List<Integer>> itemGroupMap = new HashMap<>();
        for (int item : itemList) {
            int curGroup = group[item];
            List<Integer> list = itemGroupMap.getOrDefault(curGroup, new ArrayList<>());
            list.add(item);
            itemGroupMap.put(curGroup, list);
        }
        int[] result = new int[n];
        int index = 0;
        for (int curGroup : groupList) {
            List<Integer> list = itemGroupMap.getOrDefault(curGroup, new ArrayList<>());
            for (int cur : list) {
                result[index++] = cur;
            }
        }
        return result;
    }
    private List<Integer> topologicalSort(int[] indegree, Map<Integer, List<Integer>> map, int n) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int cur = queue.poll();
            n--;
            result.add(cur);
            for (int next : map.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return n != 0 ? new ArrayList<>() : result;
    }
    private void buildGroupGraph(Map<Integer, List<Integer>> graphMap, int[] groupIndegree,
                                List<List<Integer>> beforeItems, int[] group, int n) {
        for (int i = 0; i < n; ++i) {
            List<Integer> list = beforeItems.get(i);
            if (list.size() == 0) continue;
            int curItem = i;
            int curGroup = group[i];
            for (int prevItem : list) {
                int prevGroup = group[prevItem];
                if (prevGroup != curGroup) {
                    groupIndegree[curGroup]++;
                    List<Integer> groupList = graphMap.getOrDefault(prevGroup, new ArrayList<>());
                    groupList.add(curGroup);
                    graphMap.put(prevGroup, groupList);
                }
            }
        }
    }
    private void buildItemGraph(Map<Integer, List<Integer>> itemMap, int[] itemIndegree,
                                List<List<Integer>> beforeItems, int n) {
        for (int i = 0; i < n; ++i) {
            List<Integer> list = beforeItems.get(i);
            if (list.size() == 0) continue;
            int curItem = i;
            for (int prevItem : list) {
                itemIndegree[curItem]++;
                List<Integer> itemList = itemMap.getOrDefault(prevItem, new ArrayList<>());
                itemList.add(curItem);
                itemMap.put(prevItem, itemList);
            }
        }
    }
}











