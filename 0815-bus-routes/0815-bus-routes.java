class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int stop : routes[i]) {
                Set<Integer> set = map.getOrDefault(stop, new HashSet<>());
                set.add(i);
                map.put(stop, set);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int step = 0;
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int curStop = queue.poll();
                if (curStop == target) {
                    return step;
                }
                if (visited.contains(curStop)) continue;
                visited.add(curStop);
                if (map.containsKey(curStop)) {
                    for (int nextRoute : map.get(curStop)) {
                        if (visitedRoutes.contains(nextRoute)) continue;
                        visitedRoutes.add(nextRoute);
                        for (int nextStop : routes[nextRoute]) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}