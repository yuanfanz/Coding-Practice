class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int len = pref.length();
        
        for (String word : words) {
            if (word.length() < len) continue;
            String prefix = word.substring(0, len);
            if (prefix.equals(pref)) {
                count++;
            }
        }
        return count;
    }
}