class Solution {
    public int minTransfers(int[][] transactions) {
        int[] debt = buildDebt(transactions);
        
        return getNum(0, debt);
    }
    private int getNum(int cur, int[] arr) {
        while (cur < arr.length && arr[cur] == 0) {
            cur++;
        }
        if (cur == arr.length) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = cur + 1; i < arr.length; ++i) {
            if (arr[cur] * arr[i] < 0) {
                arr[i] += arr[cur];
                min = Math.min(min, getNum(cur + 1, arr) + 1);
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
            int num = cur[2];
            map.put(giver, map.getOrDefault(giver, 0) + num);
            map.put(taker, map.getOrDefault(taker, 0) - num);
        }
        int[] arr = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            arr[index++] = map.get(key);
        }
        return arr;
    }
}