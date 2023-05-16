class Solution {
    public int minCostII(int[][] costs) {
        int m = costs.length;
        int n = costs[0].length;
        
        int first = -1;
        int second = -1;
        for (int j = 0; j < n; ++j) {
            if (costs[0][j] < (first == -1 ? Integer.MAX_VALUE : costs[0][first])) {
                second = first;
                first = j;
            } else if (costs[0][j] < (second == -1 ? Integer.MAX_VALUE : costs[0][second])) {
                second = j;
            }
        }
        int[] prev = costs[0];
        for (int i = 1; i < m; ++i) {
            int[] cur = costs[i];
            int newFirst = -1;
            int newSecond = -1;
            for (int j = 0; j < n; ++j) {
                int min = prev[first];
                if (j == first) {
                    min = prev[second];
                }
                cur[j] += min;
                if (cur[j] < (newFirst == -1 ? Integer.MAX_VALUE : cur[newFirst])) {
                    newSecond = newFirst;
                    newFirst = j;
                } else if (cur[j] < (newSecond == -1 ? Integer.MAX_VALUE : cur[newSecond])) {
                    newSecond = j;
                }
            }
            first = newFirst;
            second = newSecond;
            prev = cur;
        }
        int min = Integer.MAX_VALUE;
        for (int i : costs[m - 1]) {
            min = Math.min(min, i);
        }
        return min;
    }
}