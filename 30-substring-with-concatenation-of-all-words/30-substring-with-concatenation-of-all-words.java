class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int num = words.length;
        int len = words[0].length();
        for (int i = 0; i < s.length() - num * len + 1; ++i) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String cur = s.substring(i + j * len, i + (j + 1) * len);
                if (count.containsKey(cur)) {
                    seen.put(cur, seen.getOrDefault(cur, 0) + 1);
                    if (seen.get(cur) > count.get(cur)) {
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