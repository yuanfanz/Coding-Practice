class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] presum = new int[n + 1];
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                list.add(presum[i] - presum[j]);
            }
        }
        Collections.sort(list);
        int sum = 0;
        for (int i = left - 1; i < right; ++i) {
            sum = (sum + list.get(i)) % mod;
        }
        return sum;
    }
}