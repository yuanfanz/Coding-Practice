class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int count;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        count = 1;
    }
    
    public int popSmallest() {
        // System.out.println("count: " + count);
        if (set.size() > 0) {
            int first = set.first();
            if (first < count) {
                set.pollFirst();
                return first;
            } else {
                return count++;
            }
        } else {
            return count++;
        }
    }
    
    public void addBack(int num) {
        if (num >= count) return;
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */