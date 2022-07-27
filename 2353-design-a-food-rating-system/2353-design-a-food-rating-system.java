class FoodRatings {
    Map<String, String> map;
    Map<String, Integer> map2;
    Map<String, TreeMap<Integer, TreeSet<String>>> ratingMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map = new HashMap<>();
        map2 = new HashMap<>();
        ratingMap = new HashMap<>();
        for (String cu : cuisines) {
            ratingMap.put(cu, new TreeMap<>());
        }
        for (int i = 0; i < foods.length; ++i) {
            String cur = foods[i];
            String cu = cuisines[i];
            map.put(cur, cu);
            map2.put(cur, ratings[i]);
            
            TreeMap<Integer, TreeSet<String>> submap = ratingMap.get(cu);
            TreeSet<String> nameSet = submap.getOrDefault(ratings[i], new TreeSet<>());
            nameSet.add(cur);
            submap.put(ratings[i], nameSet);
            ratingMap.put(cu, submap);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cu = map.get(food);
        int prevRating = map2.get(food);
        map2.put(food, newRating);
        TreeMap<Integer, TreeSet<String>> submap = ratingMap.get(cu);
        TreeSet<String> nameSet = submap.get(prevRating);
        nameSet.remove(food);
        if (nameSet.size() == 0) {
            submap.remove(prevRating);
        }
        TreeSet<String> nameSet2 = submap.getOrDefault(newRating, new TreeSet<>());
        nameSet2.add(food);
        submap.put(newRating, nameSet2);
        ratingMap.put(cu, submap);
    }
    
    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> submap = ratingMap.get(cuisine);
        return submap.get(submap.lastKey()).first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */