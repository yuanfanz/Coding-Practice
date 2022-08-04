class Solution {
    public int mirrorReflection(int p, int q) {
        int m = p;
        int n = q;
        int r;
        while (n > 0) {
            r = m % n;
            m = n;
            n = r;
        }
        if ((p / m) % 2 == 0) {
            return 2;
        } else if ((q / m) % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}