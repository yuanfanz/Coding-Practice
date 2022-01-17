class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        String[] numbers = new String[]{"","","abc","def","ghi","jkl"
                                        ,"mno","pqrs","tuv","wxyz"};
        dfs(result, new StringBuilder(), digits, numbers, 0);
        return result;
    }
    private void dfs(List<String> result, StringBuilder sb, String digits,
                    String[] numbers, int index) {
        if (index == digits.length() && sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = index; i < digits.length(); ++i) {
            String cur = numbers[digits.charAt(i) - '0'];
            int len = sb.length();
            for (int j = 0; j < cur.length(); ++j) {
                sb.append(cur.charAt(j));
                dfs(result, sb, digits, numbers, i + 1);
                sb.setLength(len);
            }
        }
    }
}