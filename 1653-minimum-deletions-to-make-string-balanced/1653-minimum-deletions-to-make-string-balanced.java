class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                if (stack.size() > 0) {
                    stack.pop();
                    count++;
                }
            } else {
                stack.push(ch);
            }
        }
        return count;
    }
}