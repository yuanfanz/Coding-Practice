class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && n - (n & -n) == 0;
    }
}