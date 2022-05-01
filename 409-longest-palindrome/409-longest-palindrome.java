class Solution {
    public int longestPalindrome(String s) {
        int[] arr = new int[128];
        
        for (int i = 0; i < s.length(); ++i) {
            arr[s.charAt(i)]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i / 2) * 2;
        }
        return count == s.length() ? count : count + 1;
    }
}