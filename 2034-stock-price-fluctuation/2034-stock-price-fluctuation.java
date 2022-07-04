class StockPrice {
    // timeMap: key is timestamp, value is price
    TreeMap<Integer, Integer> timeMap;
    // valueMap: key is price, set contains timestamps
    TreeMap<Integer, Set<Integer>> valueMap;
    public StockPrice() {
        timeMap = new TreeMap<>();
        valueMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (timeMap.containsKey(timestamp)) {
            int prevPrice = timeMap.get(timestamp);
            timeMap.put(timestamp, price);
            Set<Integer> set = valueMap.get(prevPrice);
            set.remove(timestamp);
            if (set.size() == 0) {
                valueMap.remove(prevPrice);
            } else {
                valueMap.put(prevPrice, set);
            }
        } else {
            timeMap.put(timestamp, price);
        }
        Set<Integer> set = valueMap.getOrDefault(price, new HashSet<>());
        set.add(timestamp);
        valueMap.put(price, set);
    }
    
    public int current() {
        return timeMap.get(timeMap.lastKey());
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