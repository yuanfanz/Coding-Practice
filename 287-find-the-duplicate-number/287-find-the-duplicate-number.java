class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return slow;
    }
}