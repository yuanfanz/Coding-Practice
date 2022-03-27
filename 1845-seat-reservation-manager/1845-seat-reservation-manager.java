class SeatManager {
    TreeSet<Integer> set;
    int count;
    public SeatManager(int n) {
        count = 1;
        set = new TreeSet<>();
    }
    
    public int reserve() {
        if (set.size() == 0) {
            return count++;
        }
        return set.pollFirst();
    }
    
    public void unreserve(int seatNumber) {
        set.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */