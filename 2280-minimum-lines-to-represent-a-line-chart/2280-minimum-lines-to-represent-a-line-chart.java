class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length <= 1) return 0;
        if (stockPrices.length <= 2) return 1;
        
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        
        int[] prev = stockPrices[0];
        int[] cur = stockPrices[1];
        
        long diffx = (long)cur[0] - (long)prev[0];
        long diffy = (long)cur[1] - (long)prev[1];
        
        double k = (long) diffy / (long) diffx;
        
        prev = stockPrices[1];
        int count = 1;
        for (int i = 2; i < stockPrices.length; ++i) {
            cur = stockPrices[i];
            
            diffx = (long) cur[0] - (long) prev[0];
            diffy = (long) cur[1] - (long) prev[1];
            
            double curk = (double) diffy / (double) diffx;
            
            if (curk != k) {
                k = curk;
                count++;
            }
            prev = cur;
        }
        return count;
    }
    
    private void print(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}






