class Bitset {
    Set<Integer> one;
    Set<Integer> zero;
    int cap;
    public Bitset(int size) {
        one = new HashSet<>();
        zero = new HashSet<>();
        cap = size;
        for (int i = 0; i < size; ++i) {
            zero.add(i);
        }
    }
    
    public void fix(int idx) {
        one.add(idx);
        zero.remove(idx);
    }
    
    public void unfix(int idx) {
        zero.add(idx);
        one.remove(idx);
    }
    
    public void flip() {
        Set<Integer> tmp = one;
        one = zero;
        zero = tmp;
    }
    
    public boolean all() {
        return one.size() == cap;
    }
    
    public boolean one() {
        return one.size() > 0;
    }
    
    public int count() {
        return one.size();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cap; ++i) {
            if (one.contains(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */