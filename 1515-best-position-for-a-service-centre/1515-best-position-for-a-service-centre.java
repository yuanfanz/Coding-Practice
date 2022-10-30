class Solution {
    public double getMinDistSum(int[][] positions) {
        double min = Double.MAX_VALUE;
        
        double x = 50, y = 50, delta = 50;
        double min_x = x, min_y = y;
        
        double grad = 10;
        
        while (delta >= 10e-4) {
            // delta/grad is the increamental step
            // the time cost will be 200*200 each loop
            for (double i = x - delta; i <= x + delta; i += delta/grad) {
                for (double j = y - delta; j <= y + delta; j += delta/grad) {
                    double dis = getDistance(positions, i, j);
                    if (dis <= min) {
                        min = dis;
                        min_x = i;
                        min_y = j;
                    }
                }
            }
            // reset the center for the searching area to (min_x,min_y), 
            // set delta to the incremental step delta/100
            // this helps us to narrow down the results
            x = min_x;
            y = min_y;
            delta /= grad;
        }
        return min;
    }
    
    private double getDistance(int[][] positions, double x, double y) {
        double res = 0;
        for (int[] p : positions) {
            double dis = Math.pow(p[0] - x, 2) + Math.pow(p[1] - y, 2);
            res += Math.sqrt(dis);
        }
        return res;
    }
}