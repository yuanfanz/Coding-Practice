class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        
        dfs(result, new StringBuilder(), s, 0);
        return result;
    }
    private void dfs(List<String> result, StringBuilder sb, String s, int index) {
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = index; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
                dfs(result, sb, s, i + 1);
                sb.setLength(len);
            } else {
                sb.append(Character.toLowerCase(ch));
                dfs(result, sb, s, i + 1);
                sb.setLength(len);
                
                sb.append(Character.toUpperCase(ch));
                dfs(result, sb, s, i + 1);
                sb.setLength(len);
            }
        }
    }
}