class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        int[] hash = new int[26];
        int[] target = new int[26];
        int len = p.length();
        for (int i = 0; i < len; ++i) {
            target[p.charAt(i) - 'a']++;
        }
        int i = 0;
        for (int j = 0; j < s.length(); ++j) {
            hash[s.charAt(j) - 'a']++;
            while (i < s.length() && j - i + 1 > len) {
                hash[s.charAt(i++) - 'a']--;
            }
            if (isValid(hash, target)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean isValid(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}