class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i++) - '0';
            }
            if (i < s.length() && s.charAt(i) == '(') {
                int count = 1;
                int start = ++i;
                while (i < s.length() && count > 0) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } else if (s.charAt(i) == ')') {
                        count--;
                    }
                    i++;
                }
                num = calculate(s.substring(start, i - 1));
            }
            if (i >= s.length() - 1 || !Character.isDigit(s.charAt(i)) && s.charAt(i) != '(') {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                if (i < s.length()) {
                    sign = s.charAt(i);
                }
                num = 0;
            }
            i++;
        }
        int res = 0;
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}
















