class Solution {
    int maxscore = 0;
    int[] max = new int[12];
    
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[12];
        calculate(aliceArrows, bob, 11, numArrows, 0);
        return max;
    }
    
    private void calculate(int[] alice, int[] bob, int index, int remainArrows, int score) {
        if (index < 0 || remainArrows <= 0) {
            if (remainArrows > 0) {
                bob[0] += remainArrows;
            }
            if (score > maxscore) { // update highest score
                maxscore = score;
                max = bob.clone();
            }
            return;
        }
        // 1. either we try to have 1 more arrow than alice
        if (remainArrows >= alice[index] + 1) {
            bob[index] = alice[index] + 1;
            calculate(alice, bob, index - 1, remainArrows - alice[index] - 1, score + index);
            bob[index] = 0;
        }
        // 2. or no arrow and move on to next point
        calculate(alice, bob, index - 1, remainArrows, score);
        bob[index] = 0;
    }
}