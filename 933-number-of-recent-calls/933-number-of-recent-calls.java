class RecentCounter {
    List<Integer> list;
    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int index = search(list, t - 3000);
        // if (index == -1) return list.size();
        return list.size() - index;
    }
    
    private int search(List<Integer> list, int target) {
        int i = 0;
        int j = list.size() - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= list.size()) return -1;
        return i;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */