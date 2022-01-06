class Solution {
    public boolean isNumber(String s) {
        boolean seenE = false;
        boolean seenNum = false;
        boolean seenD = false;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'e':
                case 'E':
                    if (seenE || !seenNum) {
                        return false;
                    }
                    seenE = true;
                    seenNum = false;
                    break;
                case '.':
                    if (seenE || seenD) {
                        return false;
                    }
                    seenD = true;
                    break;
                case '+':
                case '-':
                    if (i != 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                        return false;
                    }
                    seenNum = false;
                    break;
                default:
                    if (ch < '0' || ch > '9') {
                        return false;
                    }
                    seenNum = true;
                    break;
            }
        }
        return seenNum;
    }
}