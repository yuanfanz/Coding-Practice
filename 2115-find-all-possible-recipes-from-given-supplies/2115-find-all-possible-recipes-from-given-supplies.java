class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        int k = 0;
        for (String r : recipes) {
            indegree.put(r, 0);
            indexMap.put(r, k++);
        }
        int n = ingredients.size();
        for (int i = 0; i < n; ++i) {
            String curRecipe = recipes[i];
            List<String> list = ingredients.get(i);
            for (String item : list) {
                if (indegree.containsKey(item)) {
                    indegree.put(curRecipe, indegree.get(curRecipe) + 1);
                    List<String> nextList = graph.getOrDefault(item, new ArrayList<>());
                    nextList.add(curRecipe);
                    graph.put(item, nextList);
                }
            }
        }
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies) {
            supplySet.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> result = new HashSet<>();
        for (String r : indegree.keySet()) {
            if (indegree.get(r) == 0) {
                int index = indexMap.get(r);
                List<String> list = ingredients.get(index);
                boolean notEnough = false;
                for (String item : list) {
                    if (!supplySet.contains(item)) {
                        notEnough = true;
                        break;
                    }
                }
                if (notEnough) continue;
                queue.offer(r);
            }
        }
        while (queue.size() > 0) {
            String cur = queue.poll();
            result.add(cur);
            supplySet.add(cur);
            if (graph.containsKey(cur)) {
                for (String next : graph.get(cur)) {
                    int val = indegree.get(next);
                    if (val < 0) continue;
                    val--;
                    if (val == 0) {
                        int index = indexMap.get(next);
                        List<String> list = ingredients.get(index);
                        boolean notEnough = false;
                        for (String item : list) {
                            if (!supplySet.contains(item)) {
                                notEnough = true;
                                break;
                            }
                        }
                        if (notEnough) continue;
                        queue.offer(next);
                    }
                    indegree.put(next, val);
                }
            }
        }
        return new ArrayList<>(result);
    }
}

















