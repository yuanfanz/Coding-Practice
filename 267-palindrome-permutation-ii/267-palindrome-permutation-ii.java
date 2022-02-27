class Solution {
    public List<String> generatePalindromes(String s) {
        Set<String> set = new HashSet<>();
        
        int[] map = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            map[s.charAt(i) - 'a']++;
        }
        boolean flag = false;
        for (int i = 0; i < 26; ++i) {
            if (map[i] % 2 == 1) {
                if (!flag) {
                    flag = true;
                } else return new ArrayList<>();
            }
        }
        int len = 0;
        String mid = "";
        for (int i = 0; i < 26; ++i) {
            if (map[i] > 0) {
                if (map[i] % 2 == 1) {
                    mid = (char) (i + 'a') + "";
                    map[i]--;
                }
                map[i] = map[i] / 2;
                len += map[i];
            }
        }
        dfs(set, "", map, len, mid);
        return new ArrayList<>(set);
    }
    private void dfs(Set<String> set, String cur, int[] map, int len, String mid) {
        if (len == cur.length()) {
            String prefix = cur;
            StringBuilder half = new StringBuilder(cur).reverse();
            String suffix = half.toString();
            set.add(prefix + mid + suffix);
            return;
        }
        for (int i = 0; i < map.length; ++i) {
            if (map[i] > 0) {
                char ch = (char) (i + 'a');
                map[i]--;
                dfs(set, cur + (char) (i + 'a'), map, len, mid);
                map[i]++;
            }
        }
    }
}







