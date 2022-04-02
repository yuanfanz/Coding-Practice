class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int j = 0;
        for (int i = 0; i < pushed.length; ++i) {
            stack.push(pushed[i]);
            while (stack.size() > 0 && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            
        }
        return stack.size() == 0 && j == popped.length;
    }
}