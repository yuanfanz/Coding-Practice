class StockPrice {
    TreeMap<Integer, Integer> map;
    TreeMap<Integer, Set<Integer>> valueMap;
    public StockPrice() {
        map = new TreeMap<>();
        valueMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int oldPrice = map.get(timestamp);
            Set<Integer> set = valueMap.get(oldPrice);
            set.remove(timestamp);
            if (set.size() == 0) {
                valueMap.remove(oldPrice);
            }
        }
        map.put(timestamp, price);
        Set<Integer> set = valueMap.getOrDefault(price, new HashSet<>());
        set.add(timestamp);
        valueMap.put(price, set);
    }
    
    public int current() {
        return map.get(map.lastKey());
    }
    
    public int maximum() {
        return valueMap.lastKey();
    }
    
    public int minimum() {
        return valueMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */