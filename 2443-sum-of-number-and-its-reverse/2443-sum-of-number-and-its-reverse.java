class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        if (num == 0) return true;
        for (int i = 0; i < num; ++i) {
            int rev = reverse(i);
            if (i + rev == num) return true;
        }
        return false;
    }
    
    public int reverse(int x) {
        int base = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (base > Integer.MAX_VALUE/10 || base == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (base < Integer.MIN_VALUE/10 || base == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            base = base * 10 + pop;
        }
        return base;
    }
}