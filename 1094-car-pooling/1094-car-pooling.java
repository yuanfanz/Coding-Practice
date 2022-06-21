class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int start = Integer.MAX_VALUE;
        int end = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] cur : trips) {
            int from = cur[1];
            int to = cur[2];
            map.put(from, map.getOrDefault(from, 0) + cur[0]);
            map.put(to, map.getOrDefault(to, 0) - cur[0]);
            start = Math.min(start, from);
            end = Math.max(end, to);
        }
        // print(map);
        int sum = 0;
        for (int i = start; i <= end; ++i) {
            if (map.containsKey(i)) {
                sum += map.get(i);
                if (sum > capacity) return false;
            }
        }
        return true;
    }
    
    private void print(Map<Integer, Integer> map) {
    for (int i : map.keySet()) {
        System.out.print(i + " " + map.get(i));
        System.out.println();
    }
}

}