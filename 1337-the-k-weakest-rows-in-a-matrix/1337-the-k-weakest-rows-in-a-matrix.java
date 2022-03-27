class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>
            ((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < mat.length; ++i) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; ++j) {
                sum += mat[i][j];
            }
            pq.offer(new int[]{i, sum});
        }
        int[] res = new int[k];
        int index = 0;
        while (pq.size() > 0 && k > 0) {
            k--;
            res[index++] = pq.poll()[0];
        }
        return res;
    }
    
}