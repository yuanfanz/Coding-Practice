class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String newStr = s + s;
        return newStr.substring(1, newStr.length() - 1).contains(s);
    }
}