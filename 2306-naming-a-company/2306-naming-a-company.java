class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> map = new HashMap<>();
        
        for (String s : ideas) {
            char ch = s.charAt(0);
            Set<String> set = map.getOrDefault(ch, new HashSet<>());
            set.add(s.substring(1));
            map.put(ch, set);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        long res = 0;
        for (int i = 0; i < list.size(); ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                Set<String> set1 = map.get(list.get(i));
                Set<String> set2 = map.get(list.get(j));
                int both = 0;
                for (String s : set1) {
                    if (set2.contains(s)) {
                        both++;
                    }
                }
                res += 2 * (set1.size() - both) * (set2.size() - both);
            }
        }
        return res;
    }
}













