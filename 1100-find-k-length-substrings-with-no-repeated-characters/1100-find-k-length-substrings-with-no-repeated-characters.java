class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int j = 0;
        int count = 0;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            while (j < s.length() && j - i < k) {
                hash[s.charAt(j++) - 'a']++;
            }
            if (j - i == k && isValid(hash)) {
                // System.out.println(s.substring(i, j));
                count++;
            }
            hash[s.charAt(i) - 'a']--;
        }
        return count;
    }
    private boolean isValid(int[] hash) {
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] > 1) {
                return false;
            }
        }
        return true;
    }
}