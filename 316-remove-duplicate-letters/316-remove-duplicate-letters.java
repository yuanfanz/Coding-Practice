class Solution {
    public String removeDuplicateLetters(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            pos[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;
            while (stack.size() > 0 && stack.peek() > ch && i < pos[stack.peek() - 'a']) {
                char prev = stack.pop();
                seen[prev - 'a'] = false;
            }
            stack.push(ch);
            seen[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}