class Solution {
    public int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, ""));
        
        // pos + speed
        Set<String> set = new HashSet<>();
        
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (cur.pos == target) {
                    // System.out.println(cur.sequence);
                    return cur.sequence.length();
                }
                String state = cur.pos + "_" + cur.speed;
                if (!set.add(state)) continue;
                int newSpeed = cur.speed > 0 ? -1 : 1;
                if (Math.abs(cur.pos + cur.speed) < 2 * target) {
                    queue.offer(new Node(cur.pos + cur.speed, cur.speed * 2, cur.sequence + "A"));
                }
                if (Math.abs(cur.pos) < 2 * target) {
                    queue.offer(new Node(cur.pos, newSpeed, cur.sequence + "R"));
                }
            }
        }
        return -1;
    }
    
    class Node{
        int pos;
        int speed;
        String sequence;
        public Node(int pos, int speed, String sequence) {
            this.pos = pos;
            this.speed = speed;
            this.sequence = sequence;
        }
    }
}