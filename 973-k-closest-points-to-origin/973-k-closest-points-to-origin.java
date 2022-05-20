class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDistance(b) - getDistance(a));
        
        for (int[] cur : points) {
            pq.offer(cur);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[][] res = new int[k][2];
        int index = 0;
        while (pq.size() > 0 && k > 0) {
            res[index++] = pq.poll();
            k--;
        }
        return res;
    }
    
    private int getDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}