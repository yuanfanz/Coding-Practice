

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
        for (int i = 0; i < schedule.size(); ++i) {
            pq.offer(new int[]{i, 0});
        }
        List<Interval> list = new ArrayList<>();
        
        int prevEnd = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int nextStart = schedule.get(cur[0]).get(cur[1]).start;
            if (prevEnd < nextStart) {
                list.add(new Interval(prevEnd, nextStart));
            }
            prevEnd = Math.max(prevEnd, schedule.get(cur[0]).get(cur[1]).end);
            if (cur[1] + 1 < schedule.get(cur[0]).size()) {
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return list;
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