class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int i = 2;
        int j = x / 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long res = (long) mid * mid;
            if (res == x) {
                return mid;
            } else if (res < x) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return j;
    }
}