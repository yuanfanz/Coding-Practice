class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        
        
        int i = 0;
        int j = 0;
        int n = tiles.length;
        int max = 0;
        int sum = 0;
        while (j < n) {
            int left = tiles[i][0];
            int right = left + carpetLen - 1;
            // if still more carpet
            if (tiles[j][1] <= right) {
                sum += tiles[j][1] - tiles[j][0] + 1;
                j++;
                max = Math.max(sum, max);
            } else {
                if (right > tiles[j][0]) {
                    max = Math.max(sum + right - tiles[j][0] + 1, max);
                }
                sum -= tiles[i][1]- tiles[i][0] + 1;
                i++;
            }
        }
        return max;
    }
}









