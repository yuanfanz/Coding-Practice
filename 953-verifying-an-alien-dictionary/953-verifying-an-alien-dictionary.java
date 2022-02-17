class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); ++i) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; ++i) {
            String first = words[i - 1];
            String second = words[i];
            for (int j = 0; j < first.length(); ++j) {
                char ch1 = first.charAt(j);
                if (j >= second.length()) return false;
                char ch2 = second.charAt(j);
                if (ch1 == ch2) continue;
                if (map[ch1 - 'a'] > map[ch2 - 'a']) {
                    // System.out.println(ch1);
                    // System.out.println(ch2);
                    // System.out.println(map[ch1 - 'a']);
                    // System.out.println(map[ch2 - 'a']);
                    return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }
}