class Solution {
    public boolean checkString(String s) {
        boolean seenA = false;
        boolean seenB = false;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                if (seenB) {
                    return false;
                }
                seenA = true;
            } else {
                seenB = true;
            }
        }
        return true;
    }
}