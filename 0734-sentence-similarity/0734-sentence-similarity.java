class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> pairs) {
        if (sentence1.length != sentence2.length) return false;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : pairs) {
            String first = p.get(0);
            String second = p.get(1);
            
            map.putIfAbsent(first, new HashSet<>());
            map.putIfAbsent(second, new HashSet<>());
            map.get(first).add(second);
            map.get(second).add(first);
        }
        
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!map.containsKey(sentence1[i])) return false;
            if (!map.get(sentence1[i]).contains(sentence2[i])) return false;
        }
        
        return true;
    }
}