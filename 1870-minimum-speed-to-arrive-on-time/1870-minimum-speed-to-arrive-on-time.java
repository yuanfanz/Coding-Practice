class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int i = 1;
        int j = 100000001;
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isValid(dist, hour, mid)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j == 100000001 ? -1 : j;
    }
    
    private boolean isValid(int[] dist, double hour, int mid) {
        double count = 0;
        for (int i = 0; i < dist.length - 1; ++i) {
            count += (double) dist[i] / (double) mid;
            if (dist[i] % mid != 0) {
                count = Math.ceil(count);
            }
        }
        count += (double) dist[dist.length - 1] / (double) mid;
        return count <= hour;
    }
}