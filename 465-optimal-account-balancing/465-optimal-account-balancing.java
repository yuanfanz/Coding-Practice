class Solution {
    public int minTransfers(int[][] transactions) {
        int[] arr = buildDebt(transactions);
        
        return getMinTransactions(0, arr);
    }
    private int getMinTransactions(int cur, int[] arr) {
        while (cur < arr.length && arr[cur] == 0) {
            cur++;
        }
        // only 1 person, no transactions needed, base case
        if (cur == arr.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = cur + 1; i < arr.length; ++i) {
            if (arr[i] * arr[cur] < 0) {
                arr[i] += arr[cur];
                min = Math.min(min, getMinTransactions(cur + 1, arr) + 1);
                arr[i] -= arr[cur];
            }
        }
        return min;
    }
    private int[] buildDebt(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] cur : transactions) {
            int giver = cur[0];
            int taker = cur[1];
            int amount = cur[2];
            map.put(giver, map.getOrDefault(giver, 0) + amount);
            map.put(taker, map.getOrDefault(taker, 0) - amount);
        }
        int[] arr = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            arr[index++] = map.get(key);
        }
        return arr;
    }
}