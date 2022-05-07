class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int n = nums.length;
        int midVal = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] < midVal) {
                return true;
            }
            while (stack.size() > 0 && nums[i] > stack.peek()) {
                midVal = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}