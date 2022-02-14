class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        boolean single = false;
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] % 2 == 1) {
                if (single) {
                    return result;
                }
                single = true;
            }
        }
        String mid = "";
        int len = 0;
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > 0) {
                if (hash[i] % 2 == 1) {
                    mid = (char) (i + 'a') + "";
                    hash[i]--;
                }
                hash[i] /= 2;
                len += hash[i];
            }
        }
        dfs(result, hash, mid, len, "");
        return result;
    }
    private void dfs(List<String> result, int[] hash, String mid, int len, String cur) {
        if (len == cur.length()) {
            StringBuilder half = new StringBuilder(cur).reverse();
            String newStr = cur + mid + half;
            result.add(newStr);
            return;
        }
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > 0) {
                hash[i]--;
                dfs(result, hash, mid, len, cur + (char)(i + 'a'));
                hash[i]++;
            }
        }
    }
}