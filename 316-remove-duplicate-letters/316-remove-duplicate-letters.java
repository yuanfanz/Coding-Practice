class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] lastIndex = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (seen[ch - 'a']) continue;
            // if there is same char we can use later in the string
            while (stack.size() > 0 && i < lastIndex[stack.peek() - 'a'] 
                   && stack.peek() > ch) {
                char last = stack.pop();
                seen[last - 'a'] = false;
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