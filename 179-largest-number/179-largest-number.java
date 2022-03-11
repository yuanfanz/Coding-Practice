class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>
            ((a, b) -> (b + a).compareTo(a + b));
        for (int i : nums) {
            pq.offer(String.valueOf(i));
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            sb.append(pq.poll());
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}