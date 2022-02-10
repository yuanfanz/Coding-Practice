class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] map = new int[256];
        int odd = 0;
        for (int i = 0; i < s.length(); ++i) {
            map[s.charAt(i)]++;
            if ((map[s.charAt(i)] & 1) == 1) {
                odd++;
            } else {
                odd--;
            }
        }
        if (odd > 1) return result;
        String mid = "";
        int length = 0;
        for (int i = 0; i < 256; ++i) {
            if (map[i] > 0) {
                if ((map[i] & 1) == 1) {
                    mid = (char) i + "";
                    map[i]--;
                }
                map[i] /= 2;
                length += map[i];
            }
        }
        dfs(result, map, length, "", mid);
        return result;
    }
    private void dfs(List<String> result, int[] map, int length, String s, String mid) {
        if (s.length() == length) {
            StringBuilder suffix = new StringBuilder(s).reverse();
            result.add(s + mid + suffix);
        }
        for (int i = 0; i < map.length; ++i) {
            if (map[i] > 0) {
                map[i]--;
                dfs(result, map, length, s + (char) i, mid);
                map[i]++;
            }
        }
    }
}











