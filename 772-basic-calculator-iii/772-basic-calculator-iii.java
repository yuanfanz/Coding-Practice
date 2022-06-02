class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        int num = 0;
        char sign = '+';
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i++) - '0';
            }
            if (i < s.length() && s.charAt(i) == '(') {
                int count = 1;
                int start = i + 1;
                int end = i + 1;
                while (end < s.length() && count > 0) {
                    if (s.charAt(end) == ')') {
                        count--;
                        if (count == 0) break;
                    } else if (s.charAt(end) == '(') {
                        count++;
                    }
                    end++;
                }
                num = calculate(s.substring(start, end));
                i = end + 1;
            }
            if (i == s.length() || !Character.isDigit(s.charAt(i)) && (s.charAt(i) != '(')) {
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
        while (stack.size() > 0) {
            res += stack.pop();
        }
        return res;
    }
}











