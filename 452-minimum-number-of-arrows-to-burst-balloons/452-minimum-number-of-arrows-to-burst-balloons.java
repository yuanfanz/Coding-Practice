class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int prevEnd = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; ++i) {
            if (prevEnd < points[i][0]) {
                count++;
                prevEnd = Math.max(prevEnd, points[i][1]);
            }
        }
        return count;
    }
}