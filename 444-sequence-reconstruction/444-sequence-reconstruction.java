class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        int[] indegree = new int[n + 1];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> list : sequences) {
            for (int i = 1; i < list.size(); ++i) {
                int first = list.get(i - 1);
                int second = list.get(i);
                List<Integer> cur = map.getOrDefault(first, new ArrayList<>());
                cur.add(second);
                map.put(first, cur);
                indegree[second]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (queue.size() > 0) {
            int size = queue.size();
            if (size > 1) return false;
            int cur = queue.poll();
            result.add(cur);
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return result.size() == n ? true : false;
    }
}