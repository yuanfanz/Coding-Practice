class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] hashs = getHash(s);
        int[] hasht = getHash(target);
        int max = s.length();
        for (int i = 0; i < hashs.length; ++i) {
            if (hasht[i] == 0) continue;
            max = Math.min(hashs[i]/hasht[i], max);
        }
        return max;
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}