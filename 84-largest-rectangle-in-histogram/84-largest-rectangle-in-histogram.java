class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        
        int n = heights.length;
        int max = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (heights[stack.peek()] <= heights[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                        int height = heights[stack.pop()];
                        int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                        max = Math.max(max, height * width);
                    }
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty() && heights[stack.peek()] > 0) {
            int height = heights[stack.pop()];
            int width = n - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(max, height * width);
        }
        return max;
    }
}