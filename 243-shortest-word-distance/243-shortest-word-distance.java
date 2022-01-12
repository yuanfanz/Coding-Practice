class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < wordsDict.length; ++i) {
            String s = wordsDict[i];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for (int i = 0; i < list1.size(); ++i) {
            for (int j= 0; j < list2.size(); ++j) {
                int abs = Math.abs(list1.get(i) - list2.get(j));
                min = Math.min(min, abs);
            }
        }
        return min;
    }
}