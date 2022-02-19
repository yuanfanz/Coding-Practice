class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (ch == stack.peek()) {
                    while (stack.size() > 0 && ch == stack.peek()) {
                        stack.pop();
                    }
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