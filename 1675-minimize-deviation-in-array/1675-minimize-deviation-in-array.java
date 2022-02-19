class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (i % 2 == 0) {
                set.add(i);
            } else {
                set.add(i * 2);
            }
        }
        int min = Integer.MAX_VALUE;
        while (true) {
            // last() returns the highest number
            int high = set.last();
            min = Math.min(min, high - set.first());
            if (high % 2 == 0) {
                set.remove(high);
                set.add(high / 2);
            } else {
                break;
            }
        }
        return min;
    }
}