class FreqStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> stackMap;
    int max;
    public FreqStack() {
        map = new HashMap<>();
        stackMap = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        int freq = map.get(val);
        max = Math.max(max, freq);
        Stack<Integer> stack = stackMap.getOrDefault(freq, new Stack<>());
        stack.push(val);
        stackMap.put(freq, stack);
    }
    
    public int pop() {
        int freq = max;
        Stack<Integer> stack = stackMap.get(freq);
        int val = stack.pop();
        map.put(val, max - 1);
        if (stack.size() == 0) {
            max--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */