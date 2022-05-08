class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        int rem = 0;
        while (numBottles > 0) {
            res += numBottles;
            numBottles += rem;
            rem = numBottles % numExchange;
            numBottles /= numExchange;
        }
        return res;
    }
}