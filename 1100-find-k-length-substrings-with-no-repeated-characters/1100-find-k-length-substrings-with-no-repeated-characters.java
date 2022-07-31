class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int i = 0;
        int[] hash = new int[26];
        int count = 0;
        for (int j = 0; j < s.length(); ++j) {
            hash[s.charAt(j) - 'a']++;
            while (i < s.length() && (!isValid(hash) || j - i + 1 > k)) {
                hash[s.charAt(i++) - 'a']--;
            }
            if (j - i + 1 == k) {
                // System.out.println(s.charAt(j));
                count++;
            }
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