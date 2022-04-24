class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int i = 0;
        int j = num / 2;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int res = num / mid;
            int rem = num % mid;
            if (res == mid && rem == 0) return true;
            if (res > mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}