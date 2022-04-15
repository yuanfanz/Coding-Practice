class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = colors.length();
        int[] indegree = new int[n];
        int[][] arr = new int[n][26];
        for (int[] cur : edges) {
            int p = cur[0];
            int q = cur[1];
            List<Integer> list = map.getOrDefault(p, new ArrayList<>());
            list.add(q);
            map.put(p, list);
            indegree[q]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
                arr[i][colors.charAt(i) - 'a'] = 1;
            }
        }
        int level = 0;
        int count = 0;
        int res = 0;
        while (queue.size() > 0) {
            int cur = queue.poll();
            count++;
            
            // for each node, get largest color values
            int max = getMax(arr[cur]);
            res = Math.max(max, res);
            
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                for (int i = 0; i < 26; ++i) {
                    arr[next][i] = Math.max(arr[next][i], 
                            arr[cur][i] + (colors.charAt(next) - 'a' == i ? 1 : 0));
                }
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == n ? res : -1;
    }
    
    private int getMax(int[] num) {
        int max = 0;
        for (int i : num) {
            max = Math.max(i, max);
        }
        return max;
    }
}


















