class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            } else {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        int maxSize = maxHeap.size();
        int minSize = minHeap.size();
        if (maxSize == minSize) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        if (maxSize - 1 == minSize) {
            return (double) (maxHeap.peek());
        }
        if (maxSize == minSize - 1) {
            return (double) (minHeap.peek());
        }
        return 0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */