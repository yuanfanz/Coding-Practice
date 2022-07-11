class Solution {
    public int minMeetingRooms(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int[] cur : intervals) {
            int start = cur[0];
            int end = cur[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        
        int num = 0;
        int max = 0;
        for (int key : map.keySet()) {
            num += map.get(key);
            max = Math.max(max, num);
        }
        return max;
    }
}