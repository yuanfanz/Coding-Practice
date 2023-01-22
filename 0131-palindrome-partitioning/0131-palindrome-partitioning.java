class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), new StringBuilder(), s, 0);
        return result;
    }
    private void dfs(List<List<String>> result, List<String> list,
                    StringBuilder sb, String s, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); ++i) {
            String str = s.substring(index, i + 1);
            if (isValid(str)) {
                list.add(str);
                dfs(result, list, sb, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    private boolean isValid(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}