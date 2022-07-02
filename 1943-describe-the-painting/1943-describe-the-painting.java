class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        
        Map<Integer, Long> map = new HashMap<>();
        int start = 100001;
        int end = 0;
        for (int[] cur : segments) {
            map.put(cur[0], map.getOrDefault(cur[0], 0L) + (long) cur[2]);
            map.put(cur[1], map.getOrDefault(cur[1], 0L) - (long) cur[2]);
            start = Math.min(start, cur[0]);
            end = Math.max(end, cur[1]);
        }
        long color = map.get(start);
        int prev = start;
        for (int i = start + 1; i <= end; ++i) {
            if (map.containsKey(i)) {
                if (color != 0) {
                    result.add(Arrays.asList((long) prev, (long) i, color));
                }
                color += map.get(i);
                prev = i;
            }
        }
        return result;
    }
}