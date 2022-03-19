class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long sum = 0;
        int count1 = 0;
        int count2 = 0;
        char ch1 = pattern.charAt(0);
        char ch2 = pattern.charAt(1);
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == ch2) {
                sum += count1;
                count2++;
            }
            if (ch == ch1) {
                count1++;
            }
        }
        return sum + Math.max(count1, count2);
    }
}