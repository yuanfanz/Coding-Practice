class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < num.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(num.charAt(i) - '0');
            } else {
                while (stack.size() > 0 && stack.peek() > num.charAt(i) - '0' && k > 0) {
                    k--;
                    stack.pop();
                }
                stack.push(num.charAt(i) - '0');
            }
        }
        while (k > 0) {
            if (stack.size() > 0) {
                stack.pop();
            }
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
        return sb.length() > 0 ? sb.toString() : "0";
    }
}