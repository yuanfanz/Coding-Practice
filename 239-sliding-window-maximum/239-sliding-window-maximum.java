class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] result = new int[nums.length - k + 1];
        // save index in deque
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (deque.size() > 0 && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}