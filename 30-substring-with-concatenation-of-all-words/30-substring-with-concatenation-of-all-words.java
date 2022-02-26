class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int num = words.length;
        for (int i = 0; i < s.length() - num * len + 1; ++i) {
            Map<String, Integer> countMap = new HashMap<>();
            int j = 0;
            while (j < num) {
                String next = s.substring(i + j * len, i + (j + 1) * len);
                if (map.containsKey(next)) {
                    countMap.put(next, countMap.getOrDefault(next, 0) + 1);
                    if (countMap.get(next) > map.get(next)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                result.add(i);
            }
        }
        return result;
    }
}