class Solution {
    public int titleToNumber(String columnTitle) {
        int num = 0;
        for (int i = 0; i < columnTitle.length(); ++i) {
            char ch = columnTitle.charAt(i);
            int cur = ch - 'A' + 1;
            num *= 26;
            num += cur;
        }
        return num;
    }
}