class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < asteroids.length; ++i) {
            int cur = asteroids[i];
            
            if (stack.size() == 0) {
                stack.push(cur);
            } else {
                boolean remain = true;
                if (cur < 0) {
                    while (stack.size() != 0 && stack.peek() > 0 && cur < 0) {
                        int pop = stack.pop();
                        if (pop == Math.abs(cur)) {
                            remain = false;
                            cur = 0;
                        } else if (pop > Math.abs(cur)) {
                            cur = 0;
                            stack.push(pop);
                            remain = false;
                        }
                    }
                }
                if (remain) {
                    stack.push(cur);
                }
            }
        }
        int[] res = new int[stack.size()];
        int tmp = stack.size() - 1;
        while (stack.size() > 0) {
            res[tmp--] = stack.pop();
        }
        return res;
    }
}