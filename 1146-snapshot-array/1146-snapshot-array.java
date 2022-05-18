class SnapshotArray {
    List<TreeMap<Integer, Integer>> list;
    int snap;
    public SnapshotArray(int length) {
        snap = 0;
        list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            list.add(new TreeMap<>());
        }
    }
    
    public void set(int index, int val) {
        list.get(index).put(snap, val);
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        Integer prev = list.get(index).floorKey(snap_id);
        if (prev != null) {
            return list.get(index).get(prev);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */