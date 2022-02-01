class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String cur : tokens) {
            if (Character.isDigit(cur.charAt(cur.length() - 1))) {
                int num = Integer.valueOf(cur);
                stack.push(num);
            } else {
                if (cur.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                }
                if (cur.equals("-")) {
                    stack.push(-stack.pop() + stack.pop());
                }
                if (cur.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                }
                if (cur.equals("/")) {
                    int first = stack.pop();
                    int second = stack.pop();
                    stack.push(second/first);
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