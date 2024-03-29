class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            hash[s.charAt(j) - 'A']++;
            while (i < s.length() && j - i + 1 - getMax(hash) > k) {
                hash[s.charAt(i++) - 'A']--;
            }
            if (j - i + 1 - getMax(hash) <= k) {
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
    private int getMax(int[] hash) {
        int max = 0;
        for (int i = 0; i < hash.length; ++i) {
            max = Math.max(max, hash[i]);
        }
        return max;
    }
}