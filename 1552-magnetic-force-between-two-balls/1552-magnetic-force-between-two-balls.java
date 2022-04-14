class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int i = 1;
        int j = (int) Math.pow(10, 9);
        
        while (i < j) {
            int mid = i + ((j - i) + 1) / 2;
            if (!isValid(position, mid, m)) {
                j = mid - 1;
            } else {
                // System.out.println("i " + i);
                // System.out.println("j " + j);
                i = mid;
            }
        }
        return i;
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
        // System.out.println("count " + count);
        return count >= m;
    }
}


























