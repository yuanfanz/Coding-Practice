class Solution {
    public boolean detectCapitalUse(String word) {
        int upCount = 0;
        int lowCount = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isUpperCase(word.charAt(i))) {
                if (lowCount != 0) return false;
                upCount++;
            } else {
                lowCount++;
            }
        }
        return upCount == word.length() || upCount == 1 || lowCount == word.length();
    }
}