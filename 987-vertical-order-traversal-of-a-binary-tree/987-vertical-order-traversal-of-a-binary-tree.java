
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Tuple>> map = new HashMap<>();
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(0, 0, root));
        int min = 0;
        int max = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Tuple tuple = queue.poll();
                int index = tuple.index;
                int level = tuple.level;
                TreeNode node = tuple.node;
                if (node == null) continue;
                min = Math.min(min, index);
                max = Math.max(max, index);
                List<Tuple> list = map.getOrDefault(index, new ArrayList<>());
                list.add(tuple);
                map.put(index, list);
                queue.offer(new Tuple(index - 1, level + 1, node.left));
                queue.offer(new Tuple(index + 1, level + 1, node.right));
            }
        }
        for (int i = min; i <= max; ++i) {
            int index = i;
            List<Tuple> list = map.get(index);
            if (list == null) continue;
            Collections.sort(list, new Comparator<>(){
                @Override
                public int compare(Tuple t1, Tuple t2) {
                    if (t1.level == t2.level) {
                        return t1.node.val - t2.node.val;
                    } else {
                        return t1.level - t2.level;
                    }
                }
            });
            List<Integer> newList = new ArrayList<>();
            for (Tuple t : list) {
                newList.add(t.node.val);
            }
            result.add(new ArrayList<>(newList));
        }
        return result;
    }
    class Tuple{
        int index;
        int level;
        TreeNode node;
        public Tuple(int index, int level, TreeNode node) {
            this.index = index;
            this.level = level;
            this.node = node;
        }
    }
}