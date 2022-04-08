class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < m; ++i) {
            int left = findLeft(mat[i]);
            if (left == -1) {
                pq.offer(new int[]{i, n});
            } else {
                pq.offer(new int[]{i, left});
            }
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int index = k - 1;
        while (pq.size() > 0 && index >= 0) {
            res[index--] = pq.poll()[0];
        }
        return res;
    }
    
    private int findLeft(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j){
            int mid = i + (j - i) / 2;
            if (nums[mid] == 0) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= nums.length || nums[i] != 0) {
            return -1;
        }
        return i;
    }
}