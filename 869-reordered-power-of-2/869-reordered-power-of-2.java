class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        
        int max = (int) Math.pow(10, 9);
        int num = 1;
        while (num <= max) {
            set.add(String.valueOf(num));
            num *= 2;
        }
        int[] hash = getHash(String.valueOf(n));
        for (String s : set) {
            if (isValid(hash, getHash(s))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isValid(int[] hash1, int[] hash2) {
        for (int i = 0; i < hash1.length; ++i) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[10];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - '0']++;
        }
        return hash;
    }
}