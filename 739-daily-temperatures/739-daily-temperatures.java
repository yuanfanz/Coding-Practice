class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        
        int[] result = new int[temperatures.length];
        stack.push(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; ++i) {
            int cur = temperatures[i];
            if (stack.isEmpty()) {
                stack.push(new int[]{cur, i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < cur) {
                    int[] prev = stack.pop();
                    result[prev[1]] = i - prev[1];
                }
                stack.push(new int[]{cur, i});
            }
        }
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            result[cur[1]] = 0;
        }
        return result;
    }
}