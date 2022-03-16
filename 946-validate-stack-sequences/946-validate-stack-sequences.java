class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int index = 0;
        for (int p : pushed) {
            stack.push(p);
            while (stack.size() > 0 && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}