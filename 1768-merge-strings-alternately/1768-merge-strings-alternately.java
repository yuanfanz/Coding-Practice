class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            String ch1 = i < word1.length() ? word1.charAt(i) + "" : "";
            String ch2 = j < word2.length() ? word2.charAt(j) + "" : "";
            sb.append(ch1);
            sb.append(ch2);
            i++;
            j++;
        }
        return sb.toString();
    }
}