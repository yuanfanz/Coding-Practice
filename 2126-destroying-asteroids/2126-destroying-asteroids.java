class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long m = mass;
        Arrays.sort(asteroids);
        for (int i = 0; i < asteroids.length; ++i) {
            int cur = asteroids[i];
            if (m < cur) {
                return false;
            } else {
                m += cur;
            }
        }
        return true;
    }
}