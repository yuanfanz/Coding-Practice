class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                    int index = stack.pop();
                    int height = heights[index];
                    int bar = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                    max = Math.max(max, height * bar);
                }
                stack.push(i);
            }
        }
        while (stack.size() > 0 ) {
            int height = heights[stack.pop()];
            int bar = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(max, height * bar);
        }
        return max;
    }
}