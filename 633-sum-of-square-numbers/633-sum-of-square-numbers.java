class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (long) Math.sqrt(c);
        while (i <= j) {
            long cur = i * i + j * j;
            if (cur < c) {
                i++;
            } else if (cur > c) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}