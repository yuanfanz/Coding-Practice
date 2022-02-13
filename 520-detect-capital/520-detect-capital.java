class Solution {
    public boolean detectCapitalUse(String word) {
        int capital = 0;
        boolean lower = false;
        for (int i = 0; i < word.length(); ++i) {
            if (Character.isUpperCase(word.charAt(i))) {
                capital++;
                if (capital > 1 && lower) {
                    return false;
                }
            } else {
                lower = true;
            }
        }
        return capital == word.length() || capital == 1 && Character.isUpperCase(word.charAt(0)) || capital == 0;
    }
}