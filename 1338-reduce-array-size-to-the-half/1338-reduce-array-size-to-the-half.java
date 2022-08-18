class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Node> list = new ArrayList<>();
        for (int num : map.keySet()) {
            list.add(new Node(num, map.get(num)));
        }
        Collections.sort(list, (a, b) -> b.freq - a.freq);
        int len = arr.length;
        int rem = len;
        int count = 0;
        for (Node cur : list) {
            int val = cur.freq;
            rem -= val;
            count++;
            if (rem <= len / 2) {
                return count;
            }
        }
        return count;
    }
    class Node {
        int num;
        int freq;
        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}