class Solution {
    public int arrangeCoins(int n) {
        if (n <= 1) {
            return n;
        }
        if (n <= 3) {
            return n == 3 ? 2 : 1;
        }

        long i = 1;
        long j = n;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            long res = (1 + mid) * mid / 2;
            if (res == n) {
                return (int) mid;
            } else if (res < n) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return (int) j;
    }
}