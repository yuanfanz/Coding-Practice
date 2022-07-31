class Solution {
    public boolean isIsomorphic(String s, String t) {
        return getPatternString(s).equals(getPatternString(t));
    }
    
    private String getPatternString(String s) {
        int[] hash = getHash(s);
        int[] lastIndex = new int[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (hash[ch] == 0) continue;
            sb.append(hash[ch] + "_" + lastIndex[ch] + "_");
            hash[ch]--;
            lastIndex[ch] = i;
        }
        return sb.toString();
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }
}