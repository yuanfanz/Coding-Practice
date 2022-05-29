class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] values = new int[n];
        
        for (int i = 0; i < n; ++i) {
            String s = words[i];
            int num = 0;
            for (int j = 0; j < s.length(); ++j) {
                num = num | 1 << (s.charAt(j) - 'a');
            }
            values[i] = num;
        }
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (((values[i] & values[j]) == 0) && 
                    words[i].length() * words[j].length() > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}