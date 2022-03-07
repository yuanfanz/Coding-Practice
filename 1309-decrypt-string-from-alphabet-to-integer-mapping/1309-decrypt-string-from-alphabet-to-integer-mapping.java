class Solution {
    public String freqAlphabets(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            stack.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            char ch = stack.peek();
            if (ch == '#') {
                stack.pop();
                int num = 0;
                int digit = stack.pop() - '0';
                num = (stack.pop() - '0') * 10 + digit;
                sb.append((char) (num - 1 + 'a'));
            } else {
                sb.append((char) ((stack.pop() - '0') - 1 + 'a'));
            }
        }
        return sb.reverse().toString();
    }
}