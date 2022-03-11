class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = x + a + b + 1;
        Set<Integer> set = new HashSet<>();
        for (int i : forbidden) {
            set.add(i);
            max = Math.max(max, i + a + b + 1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[] visited = new boolean[max];
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cur = queue.poll();
                int pos = cur[0];
                if (pos == x) return step;
                if (visited[pos]) continue;
                visited[pos] = true;
                int last = cur[1];
                if (last != -1) {
                    int next = pos - b;
                    if (next >= 0 && !set.contains(next)) {
                        queue.offer(new int[]{next, -1});
                    }
                }
                int next = pos + a;
                if (next < max && !set.contains(next)) {
                    queue.offer(new int[]{next, 1});
                }
            }
            step++;
        }
        return -1;
    }
}









