class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        boolean single = false;
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] % 2 == 1) {
                if (single) {
                    return false;
                }
                single = true;
            }
        }
        return true;
    }
}