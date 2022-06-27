class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        
        // deque stores index
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        for (int i = 1; i < n; ++i) {
            nums[i] = nums[i] + nums[deque.peekFirst()];
            while (deque.size() > 0 && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            // remove index that out of sliding window
            while (deque.size() > 0 && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
        }
        return nums[n - 1];
    }
}