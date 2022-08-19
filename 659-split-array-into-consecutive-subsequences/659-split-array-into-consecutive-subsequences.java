class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<Interval> pq = new PriorityQueue<>
            ((a, b) -> a.end == b.end ? a.len - b.len : a.end - b.end);
        for (int num : nums) {
            while (pq.size() > 0 && pq.peek().end + 1 < num) {
                if (pq.poll().len < 3) return false;
            }
            if (pq.size() == 0 || pq.peek().end == num) {
                pq.offer(new Interval(num, num));
            } else { // pq.peek().end + 1 == num
                pq.offer(new Interval(pq.poll().start, num));
            }
        }
        while (pq.size() > 0) {
            if (pq.poll().len < 3) return false;
        }
        return true;
    }
    
    class Interval{
        int start;
        int end;
        int len;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            len = end - start + 1;
        }
    }
}