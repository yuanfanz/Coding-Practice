class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        
        dfs(result, "", num, target, 0, 0, 0);
        return result;
    }
    private void dfs(List<String> result, String path,
                    String s, int target, int index, long sum, long prev) {
        if (index == s.length() && sum == target) {
            result.add(path);
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            if (i != index && s.charAt(index) == '0') return;
            Long val = Long.valueOf(s.substring(index, i + 1));
            if (index == 0) {
                dfs(result, path + val, s, target, i + 1, val, val);
            } else {
                dfs(result, path + "+" + val, s, target, i + 1, sum + val, val);
                dfs(result, path + "-" + val, s, target, i + 1, sum - val, -val);
                dfs(result, path + "*" + val, s, target, i + 1, sum - prev + prev * val, prev * val);
            }
        }
    }
}