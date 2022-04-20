class SummaryRanges {
    // start of the interval is key
    // interval is value
    TreeMap<Integer, int[]> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        Integer left = map.lowerKey(val);
        Integer right = map.higherKey(val);
        // has left and right
        // and new value can connect them
        if (left != null && right != null 
            && map.get(left)[1] + 1 == val && right == val + 1) {
            // merge the interval, remove right interval
            map.get(left)[1] = map.get(right)[1];
            map.remove(right);
        } else if (left != null && map.get(left)[1] + 1 >= val) {
            // only has left
            // and new value possibly update left interval
            map.get(left)[1] = Math.max(map.get(left)[1], val);
        } else if (right != null && right == val + 1) {
            // only has right
            // and new value can connect right interval
            map.put(val, new int[]{val, map.get(right)[1]});
            map.remove(right);
        } else {
            map.put(val, new int[]{val, val});
        }
    }
    
    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>(map.values());
        int index = 0;
        int[][] res = new int[list.size()][2];
        for (int[] cur : list) {
            res[index++] = cur;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */











