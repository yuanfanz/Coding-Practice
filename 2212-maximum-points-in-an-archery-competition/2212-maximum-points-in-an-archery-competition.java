class Solution {
    int[] maxArr;
    int max;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        maxArr = new int[12];
        max = 0;
        int[] bob = new int[12];
        dfs(bob, aliceArrows, numArrows, 11, 0);
        return maxArr;
    }
    private void dfs(int[] bob, int[] alice, int remain, int index, int score) {
        if (index < 0 || remain <= 0) {
            if (remain > 0) {
                bob[0] += remain;
            }
            if (score > max) {
                maxArr = bob.clone();
                max = score;
            }
            return;
        }
        if (remain >= alice[index] + 1) {
            bob[index] = alice[index] + 1;
            dfs(bob, alice, remain - alice[index] - 1, index - 1, score + index);
            bob[index] = 0;
        }
        bob[index] = 0;
        dfs(bob, alice, remain, index - 1, score);
        bob[index] = 0;
    }
}
