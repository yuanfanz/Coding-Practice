class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; ++i) {
            String s = wordsDict[i];
            List<Integer> list = map.getOrDefault(s, new ArrayList<>());
            list.add(i);
            map.put(s, list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            min = Math.min(min, Math.abs(index1 - index2));
            if (index1 < index2) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2)
;
 

*/