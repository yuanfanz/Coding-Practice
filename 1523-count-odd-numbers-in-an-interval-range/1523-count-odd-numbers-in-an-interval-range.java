class Solution {
    public int countOdds(int low, int high) {
        int count = 0;
        if (high % 2 == 1) {
            high--;
            count++;
        }
        if (low % 2 == 1) {
            low++;
            count++;
        }
        return count + (high - low) / 2;
    }
}