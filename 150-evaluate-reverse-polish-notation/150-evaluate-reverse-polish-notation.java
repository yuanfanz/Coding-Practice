class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(s.length() - 1))) {
                stack.push(Integer.valueOf(s));
            } else {
                if (s.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                }
                if (s.equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                }
                if (s.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                }
                if (s.equals("/")) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second / first);
                }
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}