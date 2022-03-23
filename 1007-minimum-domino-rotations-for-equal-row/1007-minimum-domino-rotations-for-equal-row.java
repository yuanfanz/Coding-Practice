class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] toparr = new int[7];
        int[] bottomarr = new int[7];
        int[] same = new int[7];
        
        int n = tops.length;
        for (int i = 0; i < n; ++i) {
            toparr[tops[i]]++;
            bottomarr[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; ++i) {
            int l1 = toparr[i];
            int l2 = bottomarr[i];
            if (l1 + l2 - same[i] == n) {
                return Math.min(n - l1, n - l2);
            }
        }
        return -1;
    }
}