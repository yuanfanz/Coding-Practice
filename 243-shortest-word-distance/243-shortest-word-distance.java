class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int left = -1;
        int right = -1;
        int min = wordsDict.length + 1;
        for (int i = 0; i < wordsDict.length; ++i) {
            if (word1.equals(wordsDict[i])) {
                left = i;
            }
            if (word2.equals(wordsDict[i])) {
                right = i;
            }
            if (left != -1 && right != -1) {
                min = Math.min(min, Math.abs(right - left));
            }
        }
        return min;
    }
}