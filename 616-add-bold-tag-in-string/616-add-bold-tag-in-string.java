class Solution {
    public String addBoldTag(String s, String[] words) {
        boolean[] mask = new boolean[s.length()];
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (int i = 0; i < s.length(); ++i) {
            String cur = checkStart(set, s, i);
            if (cur.length() > 0) {
                for (int j = i; j < i + cur.length(); ++j) {
                    mask[j] = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < mask.length) {
            if (mask[i]) {
                sb.append("<b>");
                while (i < mask.length && mask[i]) {
                    sb.append(s.charAt(i++));
                }
                sb.append("</b>");
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
    
    private String checkStart(Set<String> set, String s, int start) {
        String res = "";
        for (String cur : set) {
            if (s.startsWith(cur, start)) {
                if (cur.length() > res.length()) {
                    res = cur;
                }
            }
        }
        return res;
    }
}










