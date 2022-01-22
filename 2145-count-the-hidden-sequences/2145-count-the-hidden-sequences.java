class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int result = 0;
        int diff = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // the possible max and min value when adding differences
        for (int i = 0; i < differences.length; ++i) {
            diff += differences[i];
            min = Math.min(min, diff);
            max = Math.max(max, diff);
        }
        for (int i = lower; i <= upper; ++i) {
            int low = i + min;
            int high = i + max;
            if (low >= lower && high <= upper) {
                result++;
            }
        }
        return result;
    }
}