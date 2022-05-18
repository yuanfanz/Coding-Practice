class SnapshotArray {
    List<List<Node>> list;
    int snap;
    public SnapshotArray(int length) {
        snap = 0;
        list = new ArrayList<>();
        for (int i = 0; i < length; ++i) {
            list.add(new ArrayList<>());
        }
    }
    
    public void set(int index, int val) {
        list.get(index).add(new Node(snap, val));
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        List<Node> nodes = list.get(index);
        // print(nodes);
        // Collections.sort(nodes, (a, b) -> a.snap - b.snap);
        int i = 0;
        int j = nodes.size() - 1;
        int ans = -1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nodes.get(mid).snap <= snap_id) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (ans != -1) return nodes.get(ans).val;
        return 0;
    }
    
    class Node {
        int snap;
        int val;

        public Node(int snap, int val) {
            this.snap = snap;
            this.val = val;
        }
    }
    
    private void print(List<Node> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i).snap + " ");
        }
        System.out.println();
    }
}
