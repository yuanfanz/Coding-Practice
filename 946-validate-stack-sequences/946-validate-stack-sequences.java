class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        for (int cur : pushed) {
            stack.push(cur);
            while (stack.size() > 0 && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}