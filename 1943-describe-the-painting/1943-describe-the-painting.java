class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> result = new ArrayList<>();
        
        Map<Integer, Long> map = new HashMap<>();
        int left = 10001;
        int right = 1;
        for (int[] cur : segments) {
            int start = cur[0];
            int end = cur[1];
            long color = cur[2];
            left = Math.min(left, start);
            right = Math.max(right, end);
            map.put(start, map.getOrDefault(start, (long)0) + color);
            map.put(end, map.getOrDefault(end, (long)0) - color);
        }
        // print(map);
        long color = map.get(left);
        int prevIndex = left;
        for (int i = left + 1; i <= right; ++i) {
            if (map.containsKey(i)) {
                if (color != 0) {
                    result.add(new ArrayList<>(Arrays.asList((long)prevIndex, (long)i, color)));
                }
                color += map.get(i);
                prevIndex = i;
            }
        }
        return result;
    }
    private void print(Map<Integer, Integer> map) {
        for (int i : map.keySet()) {
            System.out.print(i + " " + map.get(i));
            System.out.println();
        }
    }
}