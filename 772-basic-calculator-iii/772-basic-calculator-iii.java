class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
            } else if (ch == '(') {
                int index = ++i;
                int count = 1;
                while (i < s.length() && count > 0) {
                    if (s.charAt(i) == ')') {
                        count--;
                    }
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    i++;
                }
                num = calculate(s.substring(index, i - 1));
            }
            if (i >= s.length() || !Character.isDigit(s.charAt(i)) && (s.charAt(i) != '(')) {
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
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}












