class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return divideAndConquer(nums, 0, nums.length - 1);
    }
    private TreeNode divideAndConquer(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int index = start;
        int max = nums[start];
        for (int i = start; i <= end; ++i) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = divideAndConquer(nums, start, index - 1);
        node.right = divideAndConquer(nums, index + 1, end);
        return node;
    }
}