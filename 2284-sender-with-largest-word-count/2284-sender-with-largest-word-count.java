class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < senders.length; ++i) {
            String[] words = messages[i].split(" ");
            String cur = senders[i];
            map.put(cur, map.getOrDefault(cur, 0) + words.length);
        }
        int max = 0;
        String[] res = new String[1];
        res[0] = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res[0] = key;
                // System.out.println(key);
            } else if (map.get(key) == max) {
                if (key.compareTo(res[0]) > 0) {
                    res[0] = key;
                    // System.out.println(key);
                }
            }
        }
        return res[0];
    }
}