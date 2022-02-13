
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
        for (int i = 0; i < schedule.size(); ++i) {
            // add first shift of this employee
            pq.offer(new int[]{i, 0});
        }
        List<Interval> result = new ArrayList<>();
        int prevEnd = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (pq.size() != 0) {
            int[] cur = pq.poll();
            Interval interval = schedule.get(cur[0]).get(cur[1]);
            if (prevEnd < interval.start) {
                result.add(new Interval(prevEnd, interval.start));
            }
            prevEnd = Math.max(prevEnd, interval.end);
            if (schedule.get(cur[0]).size() > cur[1] + 1) {
                // add next shift of this employee
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return result;
    }
}


/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/
