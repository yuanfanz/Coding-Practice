class MyCalendar {
    private TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
        
    }
    
    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        if (prev != null && map.get(prev) > start) {
            return false;
        }
        Integer next = map.ceilingKey(start);
        if (next != null && next < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */