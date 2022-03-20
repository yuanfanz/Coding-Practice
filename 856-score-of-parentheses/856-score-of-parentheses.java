class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(Math.max(cur * 2, 1));
            }
        }
        while (stack.size() > 0) {
             score += stack.pop();
        }
        return score;
    }
}