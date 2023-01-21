class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, new StringBuilder(), s, 0, 0);
        return result;
    }
    private void dfs(List<String> result, StringBuilder sb, String s,
                    int ipIndex, int strIndex) {
        if (ipIndex > 4) return;
        if (strIndex == s.length() && ipIndex == 4) {
            sb.setLength(sb.length() - 1);
            result.add(sb.toString());
        }
        int length = sb.length();
        for (int i = 0; i < 3; ++i) {
            if (strIndex + i < s.length()) {
                String str = s.substring(strIndex, strIndex + i + 1);
                if (isValid(str)) {
                    sb.append(str);
                    sb.append('.');
                    dfs(result, sb, s, ipIndex + 1, strIndex + i + 1);
                    sb.setLength(length);
                }
            }
        }
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.valueOf(s);
        if (num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }
}