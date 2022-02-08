class Solution {
    public char findTheDifference(String s, String t) {
        int[] hash1 = getHash(s);
        int[] hash2 = getHash(t);
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] != hash2[i]) {
                return (char)(i + 'a');
            }
        }
        return 'a';
    }
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}