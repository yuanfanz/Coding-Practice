class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] target = getHash(p);
        int len = p.length();
        
        for (int i = 0; i < s.length() - len + 1; ++i) {
            int[] hash = getHash(s.substring(i, i + len));
            if (isValid(hash, target)) {
                result.add(i);
            }
        }
        return result;
    }
    private boolean isValid(int[] hash, int[] target) {
        for (int i = 0; i < hash.length; ++i) {
            if (hash[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] getHash(String p) {
        int[] target = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            target[p.charAt(i) - 'a']++;
        }
        return target;
    }
}