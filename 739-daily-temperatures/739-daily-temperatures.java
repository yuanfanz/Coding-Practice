class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}