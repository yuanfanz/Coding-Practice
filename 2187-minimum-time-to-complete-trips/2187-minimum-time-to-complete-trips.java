class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long i = 1;
        long j = Long.MAX_VALUE;
        while (i < j) {
            long currTime = i + (j - i) / 2;
            if (!isValid(time, currTime, (long) totalTrips)) {
                i = currTime + 1;
            } else {
                j = currTime;
            }
        }
        return j;
    }
    private boolean isValid(int[] time, long currTime, long totalTrips) {
        long count = 0;
        for (int i = 0; i < time.length; ++i) {
            long curTrips = currTime / (long) time[i];
            if (count + curTrips < 0) { // this deals with overflow issue
                return true;
            }
            count += curTrips;
        }
        return count >= totalTrips;
    }
}