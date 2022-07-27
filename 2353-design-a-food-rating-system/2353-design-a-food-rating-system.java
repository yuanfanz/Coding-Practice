class FoodRatings {

    Map<String, Node> map;
    Map<String, PriorityQueue<Node>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        cuisineMap = new HashMap<>();
        for (int i = 0; i < foods.length; ++i) {
            String cu = cuisines[i];
            PriorityQueue<Node> pq = cuisineMap.getOrDefault
                (cu, new PriorityQueue<>((a, b) -> 
                                a.rate == b.rate ? a.food.compareTo(b.food) : b.rate - a.rate));
            Node node = new Node(foods[i], cu, ratings[i]);
            pq.offer(node);
            cuisineMap.put(cu, pq);
            map.put(foods[i], node);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Node node = map.get(food);
        PriorityQueue<Node> pq = cuisineMap.get(node.cu);
        pq.remove(node);
        node.rate = newRating;
        pq.offer(node);
    }
    
    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().food;
    }
    
    class Node{
        String food;
        String cu;
        int rate;
        public Node(String food, String cu, int rate) {
            this.food = food;
            this.cu = cu;
            this.rate = rate;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */