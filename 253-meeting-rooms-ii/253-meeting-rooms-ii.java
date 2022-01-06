class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; ++i) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 1;
        int endPtr = 0;
        for (int i = 1; i < n; ++i) {
            if (start[i] < end[endPtr]) {
                // a meeting starts, previous meeting did not end
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }
}