class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < salary.length; ++i) {
            int cur = salary[i];
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            sum += cur;
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}