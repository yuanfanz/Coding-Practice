class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i : chalk) {
            sum += i;
        }
        long rem = (long) k % sum;
        for (int i = 0; i < chalk.length; ++i) {
            if (chalk[i] > rem) {
                return i;
            } else {
                rem -= chalk[i];
            }
        }
        return 0;
    }
}