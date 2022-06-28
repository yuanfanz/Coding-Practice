class Solution {
    public int minDeletions(String s) {
        int[] hash = getHash(s);
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < hash.length; ++i) {
            while (hash[i] != 0 && set.contains(hash[i])) {
                hash[i]--;
                count++;
            }
            set.add(hash[i]);
        }
        return count;
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}