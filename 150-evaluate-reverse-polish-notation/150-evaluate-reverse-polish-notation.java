class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; ++i) {
            String cur = tokens[i];
            char ch = cur.charAt(cur.length() - 1);
            if (Character.isDigit(ch)) {
                stack.push(Integer.valueOf(cur));
            } else {
                if (ch == '+') {
                    stack.push(stack.pop() + stack.pop());
                }
                if (ch == '-') {
                    stack.push(-stack.pop() + stack.pop());
                }
                if (ch == '*') {
                    stack.push(stack.pop() * stack.pop());
                }
                if (ch == '/') {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second/first);
                }
            }
        }
        return stack.pop();
    }
}