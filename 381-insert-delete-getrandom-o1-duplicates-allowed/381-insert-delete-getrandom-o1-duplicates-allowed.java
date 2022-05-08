class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean contain = map.containsKey(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size());
        map.put(val, set);
        list.add(val);
        return !contain;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        int pos = set.iterator().next();
        set.remove(pos);
        map.put(val, set);
        if (pos < list.size() - 1) {
            int lastValue = list.get(list.size() - 1);
            Set<Integer> lastSet = map.get(lastValue);
            lastSet.add(pos);
            lastSet.remove(list.size() - 1);
            map.put(lastValue, lastSet);
            // change arraylist
            list.set(pos, lastValue);
        }
        list.remove(list.size() - 1);
        if (map.get(val).size() == 0) {
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        
        return list.get(index);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */