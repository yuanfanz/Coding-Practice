class Solution {
    public String toLowerCase(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int cur = ch - 'A';
            // System.out.println(ch);
            // System.out.println(ch - '@');
            // System.out.println(cur);
            // System.out.println();
            if (cur < 26 && cur >= 0) {
                char next = (char) (cur + 'a');
                arr[i] = next;
            } else {
                arr[i] = ch;
            }
        }
        return String.valueOf(arr);
    }
}