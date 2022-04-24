class UndergroundSystem {
    Map<Integer, Tuple> user;
    Map<String, Map<String, List<Integer>>> map;
    public UndergroundSystem() {
        user = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Tuple tuple = new Tuple(stationName, t);
        user.put(id, tuple);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Tuple tuple = user.get(id);
        int startTime = tuple.startTime;
        int duration = t - startTime;
        String start = tuple.start;
        Map<String, List<Integer>> endMap = map.getOrDefault(start, new HashMap<>());
        List<Integer> list = endMap.getOrDefault(stationName, new ArrayList<>());
        list.add(duration);
        endMap.put(stationName, list);
        map.put(start, endMap);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Map<String, List<Integer>> endMap = map.get(startStation);
        List<Integer> list = endMap.get(endStation);
        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        return (double) (sum / list.size());
    }
    
    class Tuple{
        String start;
        String end;
        int startTime;
        int endTime;
        public Tuple(String start, int startTime) {
            this.start = start;
            this.startTime = startTime;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 *//**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 *//**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 *//**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */