class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> set = new HashSet<>();
        for (int[] cur : circles) {
            int x = cur[0];
            int y = cur[1];
            int r = cur[2];
            int minX = x - r;
            int minY = y - r;
            int maxX = x + r;
            int maxY = y + r;
            for (int i = minX; i <= maxX; ++i) {
                for (int j = minY; j <= maxY; ++j) {
                    if (isValid(i, j, x, y, r)) {
                        set.add(i + "_" + j);
                    }
                }
            }
        }
        return set.size();
    }
    
    private boolean isValid(int i, int j, int x, int y, int r) {
        return (Math.abs(i - x) * Math.abs(i - x) + 
                Math.abs(j - y) * Math.abs(j - y)) <= r * r;
    }
}