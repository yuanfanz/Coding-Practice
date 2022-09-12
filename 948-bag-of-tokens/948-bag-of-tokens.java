class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int score = 0;
        int i = 0;
        int j = tokens.length - 1;
        int res = 0;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i++];
                res = Math.max(res, ++score);
            } else if (score > 0) {
                power += tokens[j--];
                score--;
            } else {
                break;
            }
        }
        return res;
    }
}