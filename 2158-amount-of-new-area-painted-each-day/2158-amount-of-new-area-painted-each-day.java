class Solution {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        
        int[] res = new int[n];
        int[] arr = new int[50001];
        for (int i = 0; i < paint.length; ++i) {
            int start = paint[i][0];
            int end = paint[i][1];
            while (start < end) {
                // either next cell, or next non-paint cell
                int jump = Math.max(start + 1, arr[start]);
                // paint a new cell, add 1 to current paint day
                res[i] += arr[start] == 0 ? 1 : 0;
                
                arr[start] = Math.max(arr[start], end);
                start = jump;
            }
        }
        return res;
    }
}