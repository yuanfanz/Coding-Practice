class Solution {
    public String minWindow(String s, String t) {
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            hash2[t.charAt(i)]++;
        }
        
        int j = 0;
        int min = s.length() + 1;
        String[] result = new String[1];
        result[0] = "";
        for (int i = 0; i < s.length(); ++i) {
            while (j < s.length() && !isValid(hash1, hash2)) {
                hash1[s.charAt(j++)]++;
            }
            if (isValid(hash1, hash2)) {
                if (min > j - i) {
                    min = j - i;
                    result[0] = s.substring(i, j);
                }
            }
            hash1[s.charAt(i)]--;
        }
        return result[0];
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