class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        
        ArrayList[] map = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            map[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        for (List<Integer> list : sequences) {
            for (int i = 0; i < list.size() - 1; ++i) {
                int first = list.get(i);
                int second = list.get(i + 1);
                map[first].add(second);
                indegree[second]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            if (size > 1) return false;
            int cur = queue.poll();
            if (index == nums.length || cur != nums[index++]) return false;
            for (int i = 0; i < map[cur].size(); ++i) {
                int next = (int) map[cur].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return index == nums.length;
    }
}
















