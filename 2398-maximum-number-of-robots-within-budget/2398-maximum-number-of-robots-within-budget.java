class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        Deque<int[]> deque = new LinkedList<>();
        
        int i = 0;
        long sum = 0;
        long total = 0;
        int max = 0;
        int k = 0;
        int res = 0;
        for (int j = 0; j < runningCosts.length; ++j) {
            sum += runningCosts[j];
            // update max using monostack
            while (deque.size() > 0 && deque.peekLast()[0] <= chargeTimes[j]) {
                deque.pollLast();
            }
            deque.addLast(new int[]{chargeTimes[j], j});
            max = deque.peekFirst()[0];
            k = j - i + 1;
            total = k * sum + max;
            while (i < runningCosts.length && total > budget) {
                total -= max;
                sum -= runningCosts[i];
                total = sum * (k - 1);
                while (deque.size() > 0 && deque.peekFirst()[1] <= i) {
                    deque.poll();
                }
                max = deque.size() > 0 ? deque.peekFirst()[0] : 0;
                total += max;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}