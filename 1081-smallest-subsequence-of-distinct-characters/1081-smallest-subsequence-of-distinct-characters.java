class Solution {
    public String smallestSubsequence(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;
            while (stack.size() > 0 && stack.peek() > ch && pos[stack.peek() - 'a'] > i) {
                seen[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(ch);
            seen[stack.peek() - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}