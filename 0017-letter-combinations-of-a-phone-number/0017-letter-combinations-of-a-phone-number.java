class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        Map<Character, String> map = Map.of('2',"abc",'3',"def",'4',"ghi",
                                           '5',"jkl",'6',"mno",'7',"pqrs",
                                           '8',"tuv",'9',"wxyz");
        dfs(result, digits, 0, new StringBuilder(), map);
        return result;
    }
    private void dfs(List<String> result, String digits, int index,
                    StringBuilder sb, Map<Character, String> map) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); ++i) {
            sb.append(letters.charAt(i));
            dfs(result, digits, index + 1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}