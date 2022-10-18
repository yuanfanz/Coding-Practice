class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; ++i) {
            s = say(s);
        }
        return s;
    }
    private String say(String s) {
        int cur = s.charAt(0) - '0';
        int num = s.charAt(0) - '0';
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); ++i) {
            cur = s.charAt(i) - '0';
            if (cur == num) {
                count++;
            } else {
                sb.append(count);
                sb.append(num);
                count = 1;
                num = cur;
            }
        }
        sb.append(count);
        sb.append(num);
        return sb.toString();
    }
}