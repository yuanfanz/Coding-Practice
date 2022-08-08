
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0));
        int min = 0;
        int max = 0;
        while (queue.size() != 0) {
            Tuple tuple = queue.poll();
            TreeNode cur = tuple.node;
            if (cur == null) {
                continue;
            }
            int index = tuple.index;
            min = Math.min(min, index);
            max = Math.max(max, index);
            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<>());
            }
            List<Integer> list = map.get(index);
            list.add(cur.val);
            map.put(index, list);
            
            queue.offer(new Tuple(cur.left, index - 1));
            queue.offer(new Tuple(cur.right, index + 1));
        }
        for (int i = min; i <= max; ++i) {
            List<Integer> list = map.get(i);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
    class Tuple{
        TreeNode node;
        int index;
        public Tuple(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}