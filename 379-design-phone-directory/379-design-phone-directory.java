class PhoneDirectory {
    TreeSet<Integer> set;
    int size;
    int count;
    public PhoneDirectory(int maxNumbers) {
        count = 0;
        size = maxNumbers;
        set = new TreeSet<>();
    }
    
    public int get() {
        if (size == count - set.size()) {
            return -1;
        }
        if (set.size() > 0 && set.first() < count) {
            return set.pollFirst();
        }
        return count++;
    }
    
    public boolean check(int number) {
        // System.out.print(number + " ");
        // System.out.println(set.contains(number));
        
        return set.contains(number) || count <= number && number < size;
    }
    
    public void release(int number) {
        if (number >= count) return;
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