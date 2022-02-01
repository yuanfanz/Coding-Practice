class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max = Math.max(max, helper(dp));
        }
        return max;
    }
    private int helper(int[] dp) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int n = dp.length;
        for (int i = 0; i < n; ++i) {
            if (stack.isEmpty()){
                stack.push(i);
            } else {
                if (dp[stack.peek()] <= dp[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && dp[stack.peek()] > dp[i]) {
                        int height = dp[stack.pop()];
                        int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                        max = Math.max(max, height * width);
                    }
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty() && dp[stack.peek()] > 0) {
            int height = dp[stack.pop()];
            int width = n - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(max, height * width);
        }
        return max;
    }
}