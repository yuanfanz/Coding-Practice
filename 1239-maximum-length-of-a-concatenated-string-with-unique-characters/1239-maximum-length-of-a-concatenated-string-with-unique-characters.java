class Solution {
    int max = 0;
    public int maxLength(List<String> arr) {
        int n = arr.size();
        for (int i = 0; i < n; ++i) {
            String s = arr.get(i);
        }
        
        for (int i = 0; i < arr.size(); ++i) {
            dfs(arr, i, "");
        }
        return max;
    }
    private void dfs(List<String> arr, int index, String cur) {
        max = Math.max(max, cur.length());
        
        for (int i = index; i < arr.size(); ++i) {
            if (isUnique(cur + arr.get(i))) {
                dfs(arr, i + 1, cur + arr.get(i));
            }
        }
    }
    
    private boolean isUnique(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if (hash[i] > 1) return false;
        }
        return true;
    }
}
