class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Tuple> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (stack.size() > 0 && ch == stack.peek().ch) {
                int val = stack.pop().count;
                if (val + 1 < k) {
                    stack.push(new Tuple(ch, val + 1));
                }
            } else {
                stack.push(new Tuple(ch, 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            Tuple t = stack.pop();
            int val = t.count;
            char ch = t.ch;
            while (val > 0) {
                sb.append(ch);
                val--;
            }
        }
        return sb.reverse().toString();
    }
    
    class Tuple{
        char ch;
        int count;
        public Tuple(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}