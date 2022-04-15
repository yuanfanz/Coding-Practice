class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int i = 0;
        int j = position[n - 1];
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isValid(position, mid, m)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j - 1;
    }
    
    private boolean isValid(int[] position, int mid, int m) {
        int count = 1;
        int prev = position[0];
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - prev >= mid) {
                count++;
                prev = position[i];
            }
        }
        return count >= m;
    }
}