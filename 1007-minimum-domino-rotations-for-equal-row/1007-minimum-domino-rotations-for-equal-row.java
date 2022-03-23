class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] toparr = new int[7];
        int[] bottomarr = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < tops.length; ++i) {
            toparr[tops[i]]++;
            bottomarr[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; ++i) {
            int l1 = toparr[i];
            int l2 = bottomarr[i];
            if (l1 + l2 - same[i] == tops.length) {
                return Math.min(tops.length - l1, tops.length - l2);
            }
        }
        return -1;
    }
}