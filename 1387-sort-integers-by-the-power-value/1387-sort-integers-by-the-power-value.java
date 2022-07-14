class Solution {
    Map<Integer, Integer> map;
    public int getKth(int lo, int hi, int k) {
        map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        Collections.sort(list, (a, b) -> getCount(a) == getCount(b) ? 
                        a - b : getCount(a) - getCount(b));
        return list.get(k - 1);
    }
    
    private int getCount(int x) {
        if (x == 1) {
            return 0;
        }
        if (map.containsKey(x)) {
            return map.get(x);
        }
        int count = 0;
        if (x % 2 == 0) {
            count = getCount(x/2) + 1;
        } else {
            count = getCount(x*3 + 1) + 1;
        }
        map.put(x, count);
        return count;
    }
}