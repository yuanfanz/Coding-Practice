class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash1 = getHash(s);
        int[] hash2 = getHash(t);
        
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] getHash(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }
}