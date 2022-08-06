class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int cnt = minutesToTest / minutesToDie + 1, pigs = 0;
        while (Math.pow(cnt, pigs) < buckets) pigs++;
        return pigs;
    }
}