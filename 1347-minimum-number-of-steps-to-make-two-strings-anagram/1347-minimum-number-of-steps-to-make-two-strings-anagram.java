class Solution {
    public int minSteps(String s, String t) {
        int[] hash1 = getHash(s);
        int[] hash2 = getHash(t);
        
        return getDiff(hash1, hash2);
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }

    private int getDiff(int[] hash1, int[] hash2) {
        int count = 0;
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] > hash2[i]) {
                count += hash1[i] - hash2[i];
            }
        }
        return count;
    }
}