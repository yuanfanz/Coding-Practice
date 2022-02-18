class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        
        char[] arr = num.toCharArray();
        for (char ch : arr) {
            while (k > 0 && stack.size() > 0 && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while (stack.size() > 0 && k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}