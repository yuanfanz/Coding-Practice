class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash1 = getHash(ransomNote);
        int[] hash2 = getHash(magazine);
        
        return isValid(hash1, hash2);
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
            if (hash1[i] > hash2[i]) {
                return false;
            }
        }
        return true;
    }
}