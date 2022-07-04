class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> indegreeMap = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            indexMap.put(recipes[i], i);
            // only do topological sort to receipes
            // ingredients does not need topo-sort
            indegreeMap.put(recipes[i], 0);
        }
        // build graph of recipe and ingredients, build indegree
        for (int i = 0; i < recipes.length; ++i) {
            String curRecipe = recipes[i];
            List<String> ingredientsList = ingredients.get(i);
            for (String ingredient : ingredientsList) {
                if (indegreeMap.containsKey(ingredient)) { // if this ingredient is one of recipes
                    indegreeMap.put(curRecipe, indegreeMap.getOrDefault(curRecipe, 0) + 1);
                    // build graph
                    List<String> list = graph.getOrDefault(ingredient, new ArrayList<>());
                    list.add(curRecipe);
                    graph.put(ingredient, list);
                }
            }
        }
        // current supplies we already have
        Set<String> supplySet = new HashSet<>();
        for (String s : supplies) {
            supplySet.add(s);
        }
        Queue<String> queue = new LinkedList<>();
        // only put 0 indegree recipe into queue first
        for (String key : indegreeMap.keySet()) {
            if (indegreeMap.get(key) == 0) {
                // need to check if we can make this recipe
                if (checkCanMakeRecipe(key, indexMap, supplySet, ingredients)) {
                    queue.offer(key);
                }
            }
        }
        Set<String> result = new HashSet<>();
        while (queue.size() > 0) {
            String curRecipe = queue.poll();
            supplySet.add(curRecipe);
            result.add(curRecipe);
            // do BFS
            if (graph.containsKey(curRecipe)) {
                List<String> nextRecipeList = graph.get(curRecipe);
                for (String nextRecipe : nextRecipeList) {
                    int nextIndegree = indegreeMap.get(nextRecipe);
                    if (nextIndegree <= 0) continue;
                    nextIndegree--;
                    if (nextIndegree == 0) {
                        if (checkCanMakeRecipe(nextRecipe, indexMap, supplySet, ingredients)) {
                            queue.offer(nextRecipe);
                        }
                    }
                    indegreeMap.put(nextRecipe, nextIndegree);
                }
            }
        }
        return new ArrayList<>(result);
    }
    
    private boolean checkCanMakeRecipe(String key, Map<String, Integer> indexMap,
                                      Set<String> supplySet, List<List<String>> ingredients) {
        int index = indexMap.get(key);
        List<String> ingredientsList = ingredients.get(index);
        for (String s : ingredientsList) {
            if (!supplySet.contains(s)) return false;
        }
        return true;
    }
}
























