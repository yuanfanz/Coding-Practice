class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = getStack(s);
        Stack<Character> s2 = getStack(t);
        
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.pop() != s2.pop()) {
                return false;
            }
        }
        return s1.isEmpty() && s2.isEmpty();
    }
    private Stack<Character> getStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack;
    }
}