class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (stack.size() == 0) {
                stack.push(ch);
            } else {
                if (ch == '*') {
                    if (stack.size() > 0) stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}