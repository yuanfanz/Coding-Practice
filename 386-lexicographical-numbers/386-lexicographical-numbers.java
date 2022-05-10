class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; ++i) {
            dfs(result, i + "", n);
        }
        return result;
    }
    private void dfs(List<Integer> result, String cur, int n) {
        if (result.size() == n) {
            return;
        }
        int num = Integer.valueOf(cur);
        if (num > n) return;
        result.add(num);
        for (int i = 0; i <= 9; ++i) {
            num = Integer.valueOf(cur + i);
            if (num > n) return;
            dfs(result, cur + i, n);
        }
    }
}