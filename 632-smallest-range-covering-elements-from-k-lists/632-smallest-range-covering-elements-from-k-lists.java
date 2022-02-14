class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); ++i) {
            pq.offer(new Tuple(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = Integer.MAX_VALUE;
        int start = -1, end = -1;
        while (pq.size() == nums.size()) {
            Tuple cur = pq.poll();
            if (max - cur.val < range) {
                start = cur.val;
                end = max;
                range = max - cur.val;
            }
            if (cur.index + 1 < nums.get(cur.row).size()) {
                int nextVal = nums.get(cur.row).get(cur.index + 1);
                Tuple newTuple = new Tuple(cur.row, cur.index + 1, nextVal);
                pq.offer(newTuple);
                max = Math.max(max, nextVal);
            }
        }
        return new int[]{start, end};
    }
    class Tuple{
        int row;
        int index;
        int val;
        public Tuple(int row, int index, int val) {
            this.row = row;
            this.index = index;
            this.val = val;
        }
    }
}