class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>
            ((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? b - a : Math.abs(b - x) - Math.abs(a - x));
        
        for (int i : arr) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() > 0) {
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}