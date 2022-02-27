class Solution {
    public int minSteps(String s, String t) {
        int[] hash1 = getHash(s);
        int[] hash2 = getHash(t);
        
        int count = 0;
        for (int i = 0; i < 26; ++i) {
            count += Math.abs(hash1[i] - hash2[i]);
        }
        return count;
    }
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a'] ++;
        }
        return hash;
    }
}