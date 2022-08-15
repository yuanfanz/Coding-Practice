class Solution {
    public int romanToInt(String s) {
        int base = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            if (getInt(s.charAt(i)) < getInt(s.charAt(i + 1))) {
                base -= getInt(s.charAt(i));
            } else {
                base += getInt(s.charAt(i));
            }
        }
        base += getInt(s.charAt(s.length() - 1));
        return base;
    }
    private int getInt(char ch) {
        switch(ch) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}