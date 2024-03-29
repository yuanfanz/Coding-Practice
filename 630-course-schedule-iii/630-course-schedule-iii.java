class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int end = 0;
        for (int[] cur : courses) {
            end += cur[0];
            pq.offer(cur[0]);
            if (end > cur[1]) {
                end -= pq.poll();
            }
        }
        return pq.size();
    }
}