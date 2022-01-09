class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int[] hashS = new int[256];
        int[] hashT = new int[256];
        
        for (int i = 0; i < t.length(); ++i) {
            hashT[t.charAt(i)]++;
        }
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            while (j < s.length()) {
                if (isValid(hashS, hashT)) {
                    break;
                }
                hashS[s.charAt(j)]++;
                j++;
            }
            if (isValid(hashS, hashT)) {
                if (min > j - i) {
                    min = j - i;
                    result = s.substring(i, j);
                }
            }
            hashS[s.charAt(i)]--;
        }
        return result;
    }
    private boolean isValid(int[] hashS, int[] hashT) {
        for (int i = 0; i < hashS.length; ++i) {
            if (hashS[i] < hashT[i]) {
                return false;
            }
        }
        return true;
    }
}