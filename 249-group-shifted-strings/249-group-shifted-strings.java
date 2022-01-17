class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(new ArrayList<>(map.get(key)));
        }
        return result;
    }
    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (int i = 1; i < s.length(); ++i) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i - 1);
            int val = ch1 - ch2;
            if (val < 0) {
                val += 26;
            }
            sb.append(val + ",");
        }
        return sb.toString();
    }
}