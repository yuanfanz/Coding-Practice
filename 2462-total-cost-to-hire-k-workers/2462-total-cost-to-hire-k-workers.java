class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost == b.cost ? a.index - b.index : a.cost - b.cost);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candidates && i < costs.length; ++i) {
            pq.offer(new Node(i, costs[i], true, false));
            set.add(i);
        }
        int count = candidates;
        for (int i = costs.length - 1; i >= 0 && count > 0; --i) {
            if (set.contains(i)) continue;
            pq.offer(new Node(i, costs[i], false, true));
            set.add(i);
            count--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < costs.length; ++i) {
            if (set.contains(i)) continue;
            list.add(i);
        }
        
        int front = 0;
        int back = list.size() - 1;
        
        long sum = 0;
        while (pq.size() > 0 && k > 0) {
            Node cur = pq.poll();
            k--;
            sum += cur.cost;
            if (back >= front) {
                int index = -1;
                if (cur.back) {
                    index = list.get(back--);
                    pq.offer(new Node(index, costs[index], false, true));
                } else {
                    index = list.get(front++);
                    pq.offer(new Node(index, costs[index], true, false));
                }
            }
        }
        return sum;
    }
    
    class Node{
        int index;
        int cost;
        boolean front;
        boolean back;
        public Node(int index, int cost, boolean front, boolean back) {
            this.index = index;
            this.cost = cost;
            this.front = front;
            this.back = back;
        }
    }
}