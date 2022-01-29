class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] target = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            target[p.charAt(i) - 'a']++;
        }
        int[] hash = new int[26];
        int i = 0;
        for (int j = 0; j < s.length(); ++j) {
            hash[s.charAt(j) - 'a']++;
            while (i < s.length() && j - i + 1 > p.length()) {
                hash[s.charAt(i++) - 'a']--;
            }
            if (valid(hash, target)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean valid(int[] hash, int[] target) {
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}