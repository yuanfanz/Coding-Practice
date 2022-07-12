class TwoSum {
    List<Integer> list;
    Map<Integer, Integer> map;
    public TwoSum() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int number) {
        list.add(number);
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (int num1 : list) {
            int num2 = value - num1;
            if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */