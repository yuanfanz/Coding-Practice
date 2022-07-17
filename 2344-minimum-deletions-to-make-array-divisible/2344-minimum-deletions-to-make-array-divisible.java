class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int gcd = findGCD(numsDivide);
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.num == b.num ? a.freq - b.freq : a.num - b.num);
        for (int key : map.keySet()) {
            pq.offer(new Node(key, map.get(key)));
        }
        
        while (pq.size() > 0) {
            Node node = pq.poll();
            if (gcd % node.num == 0) {
                return count;
            } else {
                count += node.freq;
            }
        }
        return -1;
    }
    
    public int findGCD(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            res = gcd(res, nums[i]);
        }
        return res;
    }
    
    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
    
    class Node{
        int num;
        int freq;
        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}