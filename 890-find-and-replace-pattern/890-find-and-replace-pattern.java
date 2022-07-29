class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String patternStr = getPatternString(pattern);
        // System.out.println(pattern + " " + patternStr);
        List<String> result = new ArrayList<>();
        for (String s : words) {
            if (s.length() != pattern.length()) continue;
            // System.out.println(s + " " + getPatternString(s));
            if (patternStr.equals(getPatternString(s))) {
                result.add(s);
            }
        }
        return result;
    }
    
    private String getPatternString(String s) {
        int[] hash = getHash(s);
        int[] lastIndex = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (hash[ch - 'a'] == 0) continue;
            sb.append(hash[ch - 'a'] + "_" + lastIndex[ch - 'a'] + "_");
            hash[ch - 'a']--;
            lastIndex[ch - 'a'] = i;
        }
        return sb.toString();
    }
    
    private int[] getHash(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        return hash;
    }
}