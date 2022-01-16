class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        
        int[] start = new int[n];
        int[] end = new int[n];
        int index = 0;
        for (int[] cur : intervals) {
            start[index] = cur[0];
            end[index++] = cur[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 1;
        int endPtr = 0;
        for (int i = 1; i < n; ++i) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }
}