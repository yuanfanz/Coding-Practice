class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - k + 1; ++i) {
            String cur = s.substring(i, i + k);
            set.add(cur);
        }
        return set.size() == (1 << k);
    }
}