class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int min = words.length + 1;
        int max = 0;
        
        List[] bucket = new ArrayList[words.length + 1];
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
            min = Math.min(min, val);
            max = Math.max(max, val);
        }
        List<String> result = new ArrayList<>();
        for (int i = max; i >= min && k > 0; --i) {
            List<String> list = bucket[i];
            if (list == null) continue;
            Collections.sort(list);
            for (int j = 0;j < list.size() && k > 0; ++j) {
                result.add(list.get(j));
                k--;
            }
        }
        return result;
    }
}