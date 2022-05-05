
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        
        dfs(root, map, null);
        
        List<Integer> result = new ArrayList<>();
        if (k == 0) {
            result.add(target.val);
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        Set<TreeNode> visited = new HashSet<>();
        int count = 0;
        
        while (queue.size() != 0) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                
                if (visited.contains(node)) continue;
                visited.add(node);
                if (map.containsKey(node)) {
                    for (TreeNode next : map.get(node)) {
                        if (visited.contains(next)) continue;
                        if (k == count) {
                            result.add(next.val);
                        } else {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return result;
    }
    private void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode prev) {
        if (root == null) return;
        
        if (!map.containsKey(root)) map.put(root, new ArrayList<>());
        if (prev != null) {
            map.get(root).add(prev);
        }
        if (root.left != null) {
            map.get(root).add(root.left);
        }
        if (root.right != null) {
            map.get(root).add(root.right);
        }
        dfs(root.left, map, root);
        dfs(root.right, map, root);
    }
}