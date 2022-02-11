class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        
        int[] target = getHash(s1);
        for (int i = 0; i <= s2.length() - len1; ++i) {
            int[] hash = getHash(s2.substring(i, i + len1));
            if (isValid(target, hash)) {
                return true;
            }
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