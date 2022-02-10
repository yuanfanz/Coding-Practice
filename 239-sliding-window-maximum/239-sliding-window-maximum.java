class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            while (deque.size() > 0 && i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}