class MovingAverage {
    private Deque<Integer> deque;
    private int cap;
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        cap = size;
    }
    
    public double next(int val) {
        if (deque.size() == cap) {
            deque.pollFirst();
        }
        deque.addLast(val);
        int sum = 0;
        for (int i : deque) {
            sum += i;
        }
        return (double) sum / deque.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */