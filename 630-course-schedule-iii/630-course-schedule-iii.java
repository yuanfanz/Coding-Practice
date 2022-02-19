class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        int count = 0;
        int end = 0;
        for (int i = 0; i < courses.length; ++i) {
            int duration = courses[i][0];
            int ddl = courses[i][1];
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