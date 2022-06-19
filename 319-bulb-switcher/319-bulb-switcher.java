class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for (int i = 1; i <= n; ++i) {
            if (i * i <= n) {
                count++;
            }
            if (i * i > n) break;
        }
        return count;
    }
}