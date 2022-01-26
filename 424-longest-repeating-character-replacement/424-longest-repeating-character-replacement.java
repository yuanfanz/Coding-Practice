class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int[] hash = new int[26];
        int max = 0;
        for (int j = 0; j < s.length(); ++j) {
            hash[s.charAt(j) - 'A']++;
            while (j - i + 1 - getMax(hash) > k) {
                hash[s.charAt(i++) - 'A']--;
            }
            if (j - i + 1 - getMax(hash) <= k) {
                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
            }
        }
        return max;
    }
    private int getMax(int[] hash) {
        int count = 0;
        
        for (int i = 0; i < hash.length; ++i) {
            count = Math.max(count, hash[i]);
        }
        return count;
    }
}