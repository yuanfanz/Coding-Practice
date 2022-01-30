class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        
        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            int cur = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}