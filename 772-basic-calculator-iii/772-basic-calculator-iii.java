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
                // System.out.println(num);
            } else if (ch == '(') {
                // System.out.println("original i: " + i);
                i++;
                int index = i;
                int count = 1;
                while (i < s.length() && count > 0) {
                    if (s.charAt(i) == '(') {
                        count++;
                    }
                    if (s.charAt(i) == ')') {
                        count--;
                    }
                    i++;
                }
                // System.out.println("index: " + index);
                // System.out.println("i - 2: " + (i - 2));
                String str = s.substring(index, i - 1);
                
                // System.out.println(str);
                num = calculate(str);
                // System.out.println(num);
            }
            // System.out.println("i"+i);
            if (i >= s.length() || !Character.isDigit(s.charAt(i)) && (s.charAt(i) != '(')) {
                // System.out.println(sign);
                if (sign == '+') {
                    // System.out.println("+"+num);
                    stack.push(num);
                }
                if (sign == '-') {
                    // System.out.println("-"+num);
                    stack.push(-num);
                }
                if (sign == '*') {
                    int x = stack.pop() * num;
                    // System.out.println("+"+x);
                    stack.push(x);
                }
                if (sign == '/') {
                    int x = stack.pop() / num;
                    // System.out.println("+"+x);
                    stack.push(x);
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