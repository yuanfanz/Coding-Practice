class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int[] hash1 = getHash(s1);
        int[] hash2 = getHash(s2);
        
        if (!isValid(hash1, hash2)) return false;
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < s1.length()) {
            if (j >= s2.length()) return false;
            if (s1.charAt(i) != s2.charAt(j)) {
                if (count > 1) return false;
                count++;
            }
            i++;
            j++;
        }
        return true;
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