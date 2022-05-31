class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int num = Integer.parseInt(s.substring(0, k), 2);
        set.add(num);
        for (int i = 1; i < s.length() - k + 1; ++i) {
            num = (num - ((s.charAt(i - 1) - '0') << (k - 1))) * 2 + (s.charAt(i + k - 1) - '0');
            set.add(num);
        }
        return set.size() == (1 << k);
    }
}