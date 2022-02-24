class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            TreeNode cur = new TreeNode(nums[i]);
            while (deque.size() > 0 && deque.peekFirst().val < nums[i]) {
                cur.left = deque.pollFirst();
            }
            if (deque.size() > 0) {
                deque.peekFirst().right = cur;
            }
            deque.addFirst(cur);
        }
        return deque.size() == 0 ? null : deque.pollLast();
    }
}