class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        
        for (int cur : nums) {
            String str = String.valueOf(cur);
            pq.offer(str);
        }
        if (pq.peek().charAt(0) == '0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            sb.append(pq.poll());
        }
        return sb.toString();
    }
}