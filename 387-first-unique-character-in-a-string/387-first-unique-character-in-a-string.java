class Solution {
    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                if (map.get(s.charAt(i)) != null) {
                    map.remove(ch);
                }
            } else {
                set.add(ch);
                map.put(ch, i);
            }
        }
        return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
    }
}