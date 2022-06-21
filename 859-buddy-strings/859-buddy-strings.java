class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        
        int prev = -1;
        boolean flag = false;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (flag) return false;
                if (prev == -1) {
                    prev = i;
                } else {
                    flag = true;
                    if (s.charAt(prev) != goal.charAt(i) || s.charAt(i) != goal.charAt(prev)) {
                        return false;
                    }
                }
            }
        }
        int[] arr = getHash(s);
        if (prev == -1) {
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] > 1) return true;
            }
            return false;
        } else {
            return flag;
        }
    }
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}