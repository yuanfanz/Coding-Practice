class Solution {
    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebt(transactions);
        // int[] debt = build(transactions);
        
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
    private int[] build(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] cur : transactions) {
            int giver = cur[0];
            int taker = cur[1];
            int num = cur[2];
            map.put(giver, map.getOrDefault(giver, 0) + num);
            map.put(taker, map.getOrDefault(taker, 0) - num);
        }
        int[] arr = new int[map.size()];
        // System.out.println(map.size());
        // int[] arr = new int[25];
        int index = 0;
        for (int key : map.keySet()) {
            arr[index] = map.get(key);
            index++;
            // index+=2;
        }
        return arr;
    }
}