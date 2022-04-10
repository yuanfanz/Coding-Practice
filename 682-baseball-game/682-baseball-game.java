class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ops.length; ++i) {
            String cur = ops[i];
            if (cur.equals("C") || cur.equals("D") || cur.equals("+")) {
                if (cur.equals("C")) {
                    stack.pop();
                } else if (cur.equals("D")) {
                    stack.push(stack.peek() * 2);
                } else {
                    int last = stack.pop();
                    int prev = stack.peek();
                    stack.push(last);
                    stack.push(last + prev);
                }
            } else {
                stack.push(Integer.valueOf(cur));
            }
        }
        int sum = 0;
        while (stack.size() > 0) {
            sum += stack.pop();
        }
        return sum;
    }
}