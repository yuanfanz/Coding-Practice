class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n - k + 1];
        for (int i = 0; i < n; ++i) {
            if (deque.size() > 0 && i - k + 1 > deque.peekFirst()) {
                deque.pollFirst();
            }
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
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