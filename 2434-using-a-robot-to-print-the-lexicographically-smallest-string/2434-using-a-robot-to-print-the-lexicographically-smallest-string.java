class Solution {
    public String robotWithString(String s) {
        char[] smallestNotInStack = new char[s.length()];
        
        char[] smallest = new char[1];
        smallest[0] = s.charAt(s.length() - 1);
        smallestNotInStack[s.length() - 1] = 'z' + 1;
        for (int i = s.length() - 2; i >= 0; --i) {
            smallestNotInStack[i] = smallest[0];
            if (smallest[0] > s.charAt(i)) {
                smallest[0] = s.charAt(i);
            }
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            stack.push(ch);
            while (stack.size() > 0 && stack.peek() <= smallestNotInStack[i]) {
                sb.append(stack.pop());
            }
        }
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}