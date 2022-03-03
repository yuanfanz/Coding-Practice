
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> schedule.get(a[0]).get(a[1]).start - schedule.get(b[0]).get(b[1]).start);
        
        for (int i = 0; i < schedule.size(); ++i) {
            pq.offer(new int[]{i, 0});
        }
        int prevEnd = schedule.get(pq.peek()[0]).get(pq.peek()[1]).end;
        while (pq.size() > 0) {
            int[] cur = pq.poll();
            int nextStart = schedule.get(cur[0]).get(cur[1]).start;
            if (prevEnd < nextStart) {
                result.add(new Interval(prevEnd, nextStart));
            }
            prevEnd = Math.max(prevEnd, schedule.get(cur[0]).get(cur[1]).end);
            if (cur[1] + 1 < schedule.get(cur[0]).size()) {
                pq.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        return result;
    }
}