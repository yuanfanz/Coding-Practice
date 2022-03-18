class Solution {
    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebt(transactions);
        
        return dfs(debt, 0);
    }
    private int dfs(int[] debt, int index) {
        while (index < debt.length && debt[index] == 0) {
            index++;
        }
        if (index == debt.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < debt.length; ++i) {
            if (debt[index] * debt[i] < 0) {
                debt[i] += debt[index];
                min = Math.min(min, dfs(debt, index + 1) + 1);
                debt[i] -= debt[index];
            }
        }
        return min;
    }
    private int[] buildDebt(int[][] transactions) {
        int[] debt = new int[13];
        for (int[] cur : transactions) {
            int from = cur[0];
            int to = cur[1];
            int amount = cur[2];
            debt[from] -= amount;
            debt[to] += amount;
        }
        return debt;
    }
}