class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for (String s : tokens) {
            if (!Character.isDigit(s.charAt(s.length() - 1))) {
                int first = stack.pop();
                int second = stack.pop();
                if (s.equals("+")) {
                    stack.push(first + second);
                }
                if (s.equals("-")) {
                    stack.push(second - first);
                }
                if (s.equals("*")) {
                    stack.push(first * second);
                }
                if (s.equals("/")) {
                    stack.push(second / first);
                }
            } else {
                num = Integer.valueOf(s);
                stack.push(num);
            }
        }
        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}