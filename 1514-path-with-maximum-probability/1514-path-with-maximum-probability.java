class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; ++i) {
            int[] cur = edges[i];
            int p = cur[0];
            int q = cur[1];
            double prob = succProb[i];
            Map<Integer, Double> probmap1 = map.getOrDefault(p, new HashMap<>());
            Map<Integer, Double> probmap2 = map.getOrDefault(q, new HashMap<>());
            probmap1.put(q, prob);
            probmap2.put(p, prob);
            map.put(p, probmap1);
            map.put(q, probmap2);
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new Tuple(start, 1));
        double[] visited = new double[n];
        Arrays.fill(visited, -1);
        while (pq.size() > 0) {
            Tuple tuple = pq.poll();
            int node = tuple.node;
            double prob = tuple.prob;
            if (node == end) return prob;
            if (visited[node] != -1 && visited[node] >= prob) continue;
            visited[node] = prob;
            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    double val = prob * map.get(node).get(next);
                    pq.offer(new Tuple(next, val));
                }
            }
        }
        return 0;
    }
    
    class Tuple{
        int node;
        double prob;
        public Tuple(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}