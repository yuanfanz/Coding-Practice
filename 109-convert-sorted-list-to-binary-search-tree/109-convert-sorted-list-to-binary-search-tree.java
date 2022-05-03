
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        return dfs(head, null);
    }
    
    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head == tail) {
            return null;
        }
        ListNode mid = getMid(head, tail);
        
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = dfs(head, mid);
        TreeNode right = dfs(mid.next, tail);
        root.left = left;
        root.right = right;
        return root;
    }
    
    private ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */