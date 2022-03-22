class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = getHash(s1);
        
        int i = 0;
        int[] hash = new int[26];
        int len = s1.length();
        for (int j = 0; j < s2.length(); ++j) {
            hash[s2.charAt(j) - 'a']++;
            while (i < s2.length() && j - i + 1 > len) {
                hash[s2.charAt(i++) - 'a']--;
            }
            if (isValid(hash, target)) {
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