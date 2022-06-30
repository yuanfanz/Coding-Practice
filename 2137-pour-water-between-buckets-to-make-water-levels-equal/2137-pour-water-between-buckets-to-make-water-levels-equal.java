class Solution {
    public double equalizeWater(int[] buckets, int loss) {
        double left = 0;
        double right = 100001;
        
        double remainPercent = (double) (100 - loss) / 100;
        while (right - left > 0.00001) {
            double mid = left + (right - left) / 2;
            double have = 0;
            double need = 0;
            for (int num : buckets) {
                if (num >= mid) {
                    have += num - mid;
                } else {
                    need += mid - num;
                }
            }
            if (have * remainPercent >= need) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}