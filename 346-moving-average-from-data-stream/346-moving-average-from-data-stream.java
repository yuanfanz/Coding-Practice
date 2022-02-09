class MovingAverage {
    private Deque<Integer> deque;
    private int cap;
    private double sum;
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        cap = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (deque.size() == cap) {
            sum -= deque.pollFirst();
        }
        deque.addLast(val);
        sum += val;
        return (double) sum / deque.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */