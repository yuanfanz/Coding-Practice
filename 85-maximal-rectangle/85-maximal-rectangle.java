class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int max = 0;
        int[] dp = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max = Math.max(max, getMax(dp));
        }
        return max;
    }

    private int getMax(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            if (stack.size() == 0) {
                stack.push(i);
            } else {
                while (stack.size() > 0 && nums[i] < nums[stack.peek()]) {
                    int height = nums[stack.pop()];
                    int width = i - (stack.size() == 0 ? 0 : stack.peek() + 1);
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }
        }
        while (stack.size() > 0) {
            int height = nums[stack.pop()];
            int width = n - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(max, height * width);
        }
        return max;
    }
}