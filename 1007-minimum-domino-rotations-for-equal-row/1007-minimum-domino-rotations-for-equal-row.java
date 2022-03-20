class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        
        int n = tops.length;
        for (int i = 0; i < n; ++i) {
            countA[tops[i]]++;
            countB[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        int count = 0;
        for (int i = 1; i <= 6; ++i) {
            if (countA[i] + countB[i] - same[i] == n) {
                return Math.min(n - countA[i], n - countB[i]);
            }
        }
        return -1;
    }
}