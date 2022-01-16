class Solution {
    public int minMoves(int target, int maxDoubles) {
        int cur = target;
        int max = maxDoubles;
        int increBetweenDouble = 0;
        while (cur != 1 && max != 0) {
            if (cur % 2 == 1) {
                increBetweenDouble++;
            }
            cur /= 2;
            max--;
        }
        return cur - 1 + increBetweenDouble + maxDoubles - max;
    }
}