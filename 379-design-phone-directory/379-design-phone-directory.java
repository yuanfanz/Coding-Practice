class PhoneDirectory {
    int cap;
    Set<Integer> set;
    int cur;
    public PhoneDirectory(int maxNumbers) {
        set = new HashSet<>();
        cap = maxNumbers;
        cur = 0;
    }
    
    public int get() {
        if (set.size() > 0) {
            int val = set.iterator().next();
            set.remove(val);
            return val;
        }
        if (cur >= cap) return -1;
        return cur++;
    }
    
    public boolean check(int number) {
        if (set.contains(number)) {
            return true;
        }
        if (number < cur) {
            return false;
        }
        return true;
    }
    
    public void release(int number) {
        if (number >= cur) return;
        set.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */