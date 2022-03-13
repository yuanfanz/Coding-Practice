class Solution {
    public boolean rotateString(String s, String goal) {
        String newStr = s + s;
        return s.length() == goal.length() && 
            newStr.substring(1, newStr.length() - 1).contains(goal);
    }
}