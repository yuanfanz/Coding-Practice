class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int[] next = getNext(needle);
        int k = 0;
        for (int i = 0; i < haystack.length(); ++i) {
            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) {
                k = next[k - 1];
            }
            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
            }
            if (k == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
    private int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int k = 0;
        for (int i = 1; i < needle.length(); ++i) {
            while (k > 0 && needle.charAt(i) != needle.charAt(k)) {
                k = next[k - 1];
            }
            if (needle.charAt(k) == needle.charAt(i)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}