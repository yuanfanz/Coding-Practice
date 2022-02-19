class FreqStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> freqMap;
    int max;
    public FreqStack() {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        max = Math.max(max, freq);
        Stack<Integer> stack = freqMap.getOrDefault(freq, new Stack<>());
        stack.push(val);
        freqMap.put(freq, stack);
    }
    
    public int pop() {
        int val = freqMap.get(max).pop();
        map.put(val, max - 1);
        if (freqMap.get(max).size() == 0) {
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