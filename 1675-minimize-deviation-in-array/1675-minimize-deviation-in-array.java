class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int i : nums) {
            if (i % 2 == 1) {
                i *= 2;
            }
            set.add(i);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int max = set.last();
            int min = set.first();
            res = Math.min(res, max - min);
            if (max % 2 == 1) {
                break;
            }
            set.remove(max);
            set.add(max / 2);
        }
        return res;
    }
}