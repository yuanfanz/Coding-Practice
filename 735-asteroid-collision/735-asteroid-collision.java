class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        // + -> 
        // - <-
        for (int i = 0; i < asteroids.length; ++i) {
            int cur = asteroids[i];
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                boolean remain = true;
                // cur is <- and peek() is ->
                if (cur < 0) {
                    while (stack.size() > 0 && cur != 0 && stack.peek() > 0) {
                        int pop = stack.pop();
                        if (pop > Math.abs(cur)) {
                            remain = false;
                            stack.push(pop);
                            cur = 0;
                        } else if (pop == Math.abs(cur)) {
                            remain = false;
                            cur = 0;
                        }
                    }
                }
                if (remain) {
                    stack.push(cur);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (stack.size() > 0) {
            list.add(stack.pop());
        }
        int[] result = new int[list.size()];
        int index = list.size() - 1;
        for (int i = 0; i < list.size(); ++i) {
            result[index--] = list.get(i);
        }
        return result;
    }
}