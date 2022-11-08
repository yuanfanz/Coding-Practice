class Solution {
    public String makeGood(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (stack.size() > 0 && 
                    (Character.isLowerCase(arr[i]) && Character.isUpperCase(stack.peek()) 
                     && Character.toUpperCase(arr[i]) == stack.peek() ||
                     Character.isUpperCase(arr[i]) && Character.isLowerCase(stack.peek()) 
                     && Character.toUpperCase(stack.peek()) == arr[i])) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}