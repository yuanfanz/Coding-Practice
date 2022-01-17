class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; ++i) {
            String cur = tokens[i];
            char ch = cur.charAt(cur.length() - 1);
            int num = 0;
            boolean negFlag = false;
            if (Character.isDigit(ch)) {
                for (int j = 0; j < cur.length(); ++j) {
                    ch = cur.charAt(j);
                    if (ch == '-') {
                        negFlag = true;
                    }
                    if (ch == '-' || ch == '+') continue;
                    num = num * 10 + ch - '0';
                }
                if (negFlag) {
                    num = -num;
                }
                // System.out.println(num);
                stack.push(num);
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