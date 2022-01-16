class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            for (; j < s.length() && j < i + k; ++j) {
                sb.append(s.charAt(j));
            }
            list.add(sb.toString());
            i = j;
        }
        if (list.get(list.size() - 1).length() < k) {
            String cur = list.get(list.size() - 1);
            while (k - cur.length() > 0) {
                cur = cur + fill;
            }
            list.remove(list.size() - 1);
            list.add(cur);
        }
        String[] result = new String[list.size()];
        int index = 0;
        for (String next : list) {
            result[index++] = next;
        }
        return result;
    }
}