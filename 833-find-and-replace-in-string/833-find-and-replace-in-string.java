class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; ++i) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(i)) {
                int index = map.get(i);
                sb.append(targets[index]);
                i += sources[index].length();
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}