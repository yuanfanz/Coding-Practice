class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        int end = 0;
        int count = 0;
        for (int[] cur : courses) {
            end += cur[0];
            pq.offer(cur[0]);
            if (end > cur[1]) {
                end -= pq.poll();
            } else {
                count++;
            }
        }
        return pq.size();
    }
}