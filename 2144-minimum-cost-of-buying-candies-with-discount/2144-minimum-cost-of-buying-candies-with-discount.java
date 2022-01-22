class Solution {
    public int minimumCost(int[] cost) {
        if (cost.length < 3) {
            if (cost.length < 2) {
                return cost[0];
            }
            return cost[0] + cost[1];
        }
        Arrays.sort(cost);
        int[] arr = new int[cost.length];
        int index = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            arr[index++] = cost[i];
        }
        int sum = 0;
        for (int i = 0; i < arr.length;) {
            sum += arr[i];
            if (i + 1 < arr.length) {
                sum += arr[i + 1];
            }
            i += 3;
        }
        return sum;
    }
}