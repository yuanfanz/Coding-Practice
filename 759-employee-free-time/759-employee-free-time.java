

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        
        for (List<Interval> list : schedule){
            for (Interval cur : list) {
                pq.offer(cur);
            }
        }
        List<Interval> result = new ArrayList<>();
        Interval prev = pq.poll();
        while (pq.size() != 0) {
            if (prev.end < pq.peek().start) {
                result.add(new Interval(prev.end, pq.peek().start));
                prev = pq.poll();
            } else {
                prev.end = Math.max(prev.end, pq.peek().end);
                pq.poll();
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