class Solution {
    public String customSortString(String order, String s) {
        int[] bucket = new int[26];
        
        for (int i = 0; i < s.length(); ++i) {
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); ++i) {
            char ch = order.charAt(i);
            while (bucket[ch - 'a'] > 0) {
                sb.append(ch);
                bucket[ch - 'a']--;
            }
        }
        for (int i = 0; i < bucket.length; ++i) {
            while (bucket[i] > 0) {
                sb.append((char) ('a' + i));
                bucket[i]--;
            }
        }
        return sb.toString();
    }
}