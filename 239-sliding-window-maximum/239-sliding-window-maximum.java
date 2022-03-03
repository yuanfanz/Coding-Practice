class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            while (deque.size() > 0 && (i - k + 1) > deque.peekFirst()) {
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