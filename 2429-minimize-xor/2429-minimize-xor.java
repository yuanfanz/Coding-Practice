class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = countSetBits(num2);
        // System.out.println(count);
        int res = 0;
        for (int i = 31; i >= 0; --i) {
            if (count == 0) break;
            if ((num1 & (1 << i)) != 0) {
                res = res | (1 << i);
            // System.out.println("f: " + res);
            // System.out.println("i: " + i);
                count--;
            }
        }
        // System.out.println("res: " + Integer.toBinaryString(res));
        // System.out.println("count: " + count);
        for (int i = 0; i < 32; ++i) {
            if (count == 0) break;
            if ((res & (1 << i)) != (1 << i)) {
            // System.out.println("i: " + i);
            // System.out.println("(res & (1 << i)): " + (res & (1 << i)));
                res = res | (1 << i);
                count--;
        // System.out.println("res: " + Integer.toBinaryString(res));
            }
        }
        return res;
    }
    
    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}