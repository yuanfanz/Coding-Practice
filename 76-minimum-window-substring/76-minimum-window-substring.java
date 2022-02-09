class Solution {
    public String minWindow(String s, String t) {
        int[] target = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            target[t.charAt(i)]++;
        }
        int[] hash = new int[256];
        int j = 0;
        int min = s.length() + 1;
        String[] result = new String[1];
        result[0] = "";
        for (int i = 0; i < s.length(); ++i) {
            while (j < s.length() && !isValid(hash, target)) {
                hash[s.charAt(j++)]++;
            }
            if (isValid(hash, target)) {
                if (j - i < min) {
                    min = j - i;
                    result[0] = s.substring(i, j);
                }
            }
            hash[s.charAt(i)]--;
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