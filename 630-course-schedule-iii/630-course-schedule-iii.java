class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        int end = 0;
        int count = 0;
        for (int[] cur : courses) {
            int duration = cur[0];
            int ddl = cur[1];
            pq.offer(duration);
            end += duration;
            if (end > ddl) {
                end -= pq.poll();
            } else {
                count++;
            }
        }
        return count;
    }
}