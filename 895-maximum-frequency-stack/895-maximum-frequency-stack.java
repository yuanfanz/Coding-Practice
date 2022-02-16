class FreqStack {
    private Map<Integer, Integer> freqMap;
    private Map<Integer, Stack<Integer>> stackMap;
    private int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        stackMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int curFreq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, curFreq);
        Stack<Integer> stack = stackMap.getOrDefault(curFreq, new Stack<>());
        maxFreq = Math.max(maxFreq, curFreq);
        stack.push(val);
        stackMap.put(curFreq, stack);
    }
    
    public int pop() {
        int val = stackMap.get(maxFreq).pop();
        freqMap.put(val, maxFreq - 1);
        if (stackMap.get(maxFreq).size() == 0) {
            maxFreq--;
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