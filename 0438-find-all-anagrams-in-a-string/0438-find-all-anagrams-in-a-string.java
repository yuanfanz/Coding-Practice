class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int[] hash = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            hash[p.charAt(i) - 'a']++;
        }
        int len = p.length();
        int j = 0;
        int[] cur = new int[26];
        for (int i = 0; i <= s.length() - len; ++i) {
            while (j < i + len) {
                cur[s.charAt(j++) - 'a']++;
            }
            if (isValid(cur, hash)) {
                result.add(i);
            }
            cur[s.charAt(i) - 'a']--;
        }
        return result;
    }
    private boolean isValid(int[] cur, int[] hash) {
        for (int i = 0; i < cur.length; ++i) {
            if (cur[i] != hash[i]) {
                return false;
            }
        }
        return true;
    }
}