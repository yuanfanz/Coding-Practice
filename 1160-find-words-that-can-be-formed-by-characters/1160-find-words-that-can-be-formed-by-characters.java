class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] hash = getHash(chars);
        
        int count = 0;
        for (String s : words) {
            int[] cur = getHash(s);
            if (isValid(hash, cur)) {
                count += s.length();
            }
        }
        return count;
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
            if (hash1[i] < hash2[i]) {
                return false;
            }
        }
        return true;
    }
}