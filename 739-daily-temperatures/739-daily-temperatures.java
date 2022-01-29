class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        
        int[] result = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; ++i) {
            int cur = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < cur) {
                    int prev = stack.pop();
                    result[prev] = i - prev;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            result[cur] = 0;
        }
        return result;
    }
}