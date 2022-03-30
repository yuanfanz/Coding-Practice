class RandomizedSet {
    Map<Integer, Integer> valueMap;
    Map<Integer, Integer> locationMap;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueMap = new HashMap<>();
        locationMap = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) {
            return false;
        }
        int cap = valueMap.size();
        valueMap.put(val, cap);
        locationMap.put(cap, val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueMap.containsKey(val)) {
            return false;
        }
        int location = valueMap.get(val);
        if (location < valueMap.size() - 1) {
            // If this value is not on the last index
            // then swap it with the last index value
            int lastVal = locationMap.get(valueMap.size() - 1);
            valueMap.put(lastVal, location);
            locationMap.put(location, lastVal);
        }
        locationMap.remove(valueMap.size() - 1);
        valueMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return locationMap.get(rand.nextInt(locationMap.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */