class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = getHash(s1);
        int[] hash = new int[26];
        int len = s1.length();
        int j = 0;
        for (int i = 0; i <= s2.length() - len; ++i) {
            while (j < i + len) {
                hash[s2.charAt(j++) - 'a']++;
            }
            if (isValid(hash, target)) {
                return true;
            }
            hash[s2.charAt(i) - 'a']--;
        }
        return false;
    }
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
    private boolean isValid(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}