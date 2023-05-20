class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        for (int i = 0; i < values.length; ++i) {
            List<String> list = equations.get(i);
            String from = list.get(0);
            String to = list.get(1);
            double val = values[i];
            if (!map.containsKey(from)) map.put(from, new HashMap<>());
            if (!map.containsKey(to)) map.put(to, new HashMap<>());
            map.get(from).put(to, val);
            map.get(to).put(from, 1 / val);
        }
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        for (int i = 0; i < result.length; ++i) {
            List<String> list = queries.get(i);
            String start = list.get(0);
            String to = list.get(1);
            if (!map.containsKey(start) || !map.containsKey(to)) {
                result[i] = -1.0;
                continue;
            }
            Queue<Tuple> queue = new LinkedList<>();
            queue.offer(new Tuple(start, 1.0));
            Set<String> visited = new HashSet<>();
            while (queue.size() > 0) {
                Tuple tuple = queue.poll();
                String cur = tuple.s;
                Double val = tuple.d;
                if (cur.equals(to)) {
                    result[i] = val;
                    break;
                }
                if (visited.contains(cur)) continue;
                visited.add(cur);
                if (map.containsKey(cur)) {
                    for (String next : map.get(cur).keySet()) {
                        queue.offer(new Tuple(next, val * map.get(cur).get(next)));
                    }
                }
            }
        }
        return result;
    }
    
    class Tuple{
        String s;
        Double d;
        public Tuple(String s, Double d) {
            this.s = s;
            this.d = d;
        }
    }
}