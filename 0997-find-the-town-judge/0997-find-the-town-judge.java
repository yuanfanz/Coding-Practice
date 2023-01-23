class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n + 1];
        
        Set<Integer> set = new HashSet<>();
        for (int[] cur : trust) {
            set.add(cur[0]);
            indegree[cur[1]]++;
        }
        int result = -1;
        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == n - 1 && !set.contains(i)) {
                if (result != -1) return -1;
                result = i;
            }
        }
        return result;
    }
}