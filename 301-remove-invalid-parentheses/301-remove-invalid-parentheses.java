class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        int open = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        Set<String> result = new HashSet<>();
        dfs(result, new StringBuilder(), s, 0, left, right, open);
        return new ArrayList<>(result);
    }
    private void dfs(Set<String> result, StringBuilder sb, String s,
                    int index, int left, int right, int open) {
        if (index == s.length() && left == 0 && right == 0 && open == 0) {
            result.add(sb.toString());
            return;
        }
        if (index == s.length() || left < 0 || right < 0 || open < 0) {
            return;
        }
        int len = sb.length();
        char ch = s.charAt(index);
        if (ch == '(') {
            dfs(result, sb, s, index + 1, left - 1, right, open);
            dfs(result, sb.append(ch), s, index + 1, left, right, open + 1);
        } else if (ch == ')') {
            dfs(result, sb, s, index + 1, left, right - 1, open);
            dfs(result, sb.append(ch), s, index + 1, left, right, open - 1);
        } else {
            dfs(result, sb.append(ch), s, index + 1, left, right, open);
        }
        sb.setLength(len);
    }
}