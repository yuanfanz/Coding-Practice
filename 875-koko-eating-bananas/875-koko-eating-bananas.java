class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = (int) Math.pow(10, 9);
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!canEatAll(piles, mid, h)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return j;
    }
    private boolean canEatAll(int[] piles, int mid, int h) {
        int count = 0;
        for (int pile : piles) {
            count += pile / mid;
            if (pile % mid != 0) {
                count++;
            }
        }
        return count <= h;
    }
}