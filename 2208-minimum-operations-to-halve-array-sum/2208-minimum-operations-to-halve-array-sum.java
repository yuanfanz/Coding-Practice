class Solution {
    public int halveArray(int[] nums) {
        double[] arr = new double[nums.length];
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        int index = 0;
        for (int i : nums) {
            // arr[index++] = (double) i;
            sum += (double) i;
            pq.offer((double) i);
        }
        double half = sum / 2;
        int count = 0;
        while (pq.size() > 0 && sum > half) {
            double cur = pq.poll();
            sum -= cur / 2;
            pq.offer(cur / 2);
            count++;
        }
        return count;
    }
}