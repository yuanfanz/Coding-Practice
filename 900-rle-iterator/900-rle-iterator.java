class RLEIterator {
    int index;
    int[] arr;
    public RLEIterator(int[] encoding) {
        index = 0;
        this.arr = encoding;
    }
    
    public int next(int n) {
        while (index < arr.length && arr[index] < n) {
            n -= arr[index];
            index += 2;
        }
        if (index >= arr.length) return -1;
        arr[index] -= n;
        return arr[index + 1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */