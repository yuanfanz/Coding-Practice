class Solution {
    public int hardestWorker(int n, int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int start = 0;
        for (int[] cur : logs) {
            int id = cur[0];
            int end = cur[1];
            int duration = end - start;
            start = end;
            int last = map.getOrDefault(id, 0);
            map.put(id, Math.max(last, duration));
        }
        int max = 0;
        int res = 0;
        for (int cur : map.keySet()) {
            if (max <= map.get(cur)) {
                if (max == map.get(cur) && cur < res) {
                    res = cur;
                } else if (max < map.get(cur)) {
                    res = cur;
                }
                max = map.get(cur);
            }
        }
        return res;
    }
}