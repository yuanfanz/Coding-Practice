class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int[] target = new int[]{x, y};
        PriorityQueue<Integer> pq = new PriorityQueue<>
            ((a, b) -> getDistance(points[a], target) != getDistance(points[b], target) 
             ? getDistance(points[a], target) - getDistance(points[b], target) : a - b);
        for (int i = 0; i < points.length; ++i) {
            if (points[i][0] == x || points[i][1] == y) {
                pq.offer(i);
            }
        }
        return pq.size() > 0 ? pq.poll() : -1;
    }
    private int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] + a[1] - b[0] - b[1]);
    }
}