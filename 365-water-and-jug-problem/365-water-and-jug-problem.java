class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity == jug1Capacity || targetCapacity == jug2Capacity) return true;
        
        int max = jug1Capacity + jug2Capacity + 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(jug1Capacity);
        queue.offer(jug2Capacity);
        boolean[] visited = new boolean[max];
        while (queue.size() > 0) {
            int cur = queue.poll();
            if (cur == targetCapacity) return true;
            if (visited[cur]) continue;
            visited[cur] = true;
            int diff1 = Math.abs(cur - jug1Capacity);
            int diff2 = Math.abs(cur - jug2Capacity);
            int n1 = cur + diff1;
            int n2 = cur - diff1;
            int n3 = cur + diff2;
            int n4 = cur - diff2;
            int n5 = cur + jug1Capacity;
            int n6 = cur + jug2Capacity;
            int n7 = cur - jug1Capacity;
            int n8 = cur - jug2Capacity;
            isValid(n1, queue, max);
            isValid(n2, queue, max);
            isValid(n3, queue, max);
            isValid(n4, queue, max);
            isValid(n5, queue, max);
            isValid(n6, queue, max);
            isValid(n7, queue, max);
            isValid(n8, queue, max);
        }
        return false;
    }
    private void isValid(int n, Queue<Integer> queue, int max) {
        if (n >= 0 && n < max) {
            queue.offer(n);
            // System.out.println(n);
        }
    }
}