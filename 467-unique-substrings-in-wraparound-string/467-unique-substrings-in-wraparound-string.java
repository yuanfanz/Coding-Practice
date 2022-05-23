class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int cur = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i - 1) == 'z' && p.charAt(i) == 'a' || 
               p.charAt(i - 1) + 1 == p.charAt(i))) {
                cur++;
            } else {
                cur = 1;
            }
            int index = p.charAt(i) - 'a';
            count[index] = Math.max(count[index], cur);
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            sum += count[i];
        }
        return sum;
    }
}