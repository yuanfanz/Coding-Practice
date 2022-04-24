class UndergroundSystem {
    
    class Person{
        String start;
        String end;
        int startTime;
        int endTime;
        
        public Person(String start, int startTime) {
            this.start = start;
            this.startTime = startTime;
        }
        
        public void checkout(String end, int endTime) {
            this.end = end;
            this.endTime = endTime;
        }
    }
    
    class Route{
        String start;
        String end;
        int totalTrips;
        int totalTime;
        
        public Route(String start, String end) {
            this.start = start;
            this.end = end;
        }
        
        public void addTrip(int startTime, int endTime) {
            totalTrips++;
            totalTime += endTime - startTime;
        }
        
        public double getAverageTime() {
            return (double) totalTime / totalTrips;
        }
    }
    
    Map<Integer, Person> userMap;
    Map<String, Route> routeMap;
    
    public UndergroundSystem() {
        userMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Person person = new Person(stationName, t);
        userMap.put(id, person);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (userMap.containsKey(id)) {
            Person person = userMap.get(id);
            person.checkout(stationName, t);
            String start = person.start;
            String routeStr = start + "_" + stationName;
            Route route = routeMap.getOrDefault(routeStr, new Route(start, stationName));
            route.addTrip(person.startTime, t);
            routeMap.put(routeStr, route);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeStr = startStation + "_" + endStation;
        Route route = routeMap.get(routeStr);
        return route.getAverageTime();
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
 */