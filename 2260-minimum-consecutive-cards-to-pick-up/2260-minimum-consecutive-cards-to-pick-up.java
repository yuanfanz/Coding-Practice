class Solution {
    public int minimumCardPickup(int[] cards) {
        Set<Integer> set = new HashSet<>();
        int j = 0;
        int min = cards.length + 1;
        for (int i = 0; i < cards.length; ++i) {
            while (j < cards.length && !set.contains(cards[j])) {
                set.add(cards[j]);
                j++;
            }
            if (j < cards.length && set.contains(cards[j])) {
                min = Math.min(min, j - i + 1);
            }
            set.remove(cards[i]);
        }
        return min == cards.length + 1 ? -1 : min;
    }
}