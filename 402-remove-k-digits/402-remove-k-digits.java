class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < num.length(); ++i) {
            char ch = num.charAt(i);
            int cur = ch - '0';
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                while (stack.size() > 0 && stack.peek() > cur && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(cur);
            }
        }
        while (stack.size() > 0 && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}