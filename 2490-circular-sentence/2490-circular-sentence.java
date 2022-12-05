class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        
        char[] first = new char[1];
        first[0] = strs[0].charAt(0);
        char[] prev = new char[1];
        prev[0] = strs[0].charAt(strs[0].length() - 1);
        
        if (strs.length == 1) {
            return first[0] == prev[0];
        }
        
        for (int i = 1; i < strs.length; ++i) {
            String cur = strs[i];
            char curFirst = cur.charAt(0);
            if (curFirst != prev[0]) return false;
            prev[0] = cur.charAt(cur.length() - 1);
            
            if (i == strs.length - 1) {
                if (prev[0] != first[0]) {
                    return false;
                }
            }
        }
        return true;
    }
}