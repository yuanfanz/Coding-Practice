class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        int max = 0;
        int[] value = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int left = i - presum[i];
            int right = presum[n] - presum[i];
            value[i] = left + right;
            max = Math.max(max, left + right);
        }
        for (int i = 0; i <= n; ++i) {
            if (max == value[i]) {
                result.add(i);
            }
        }
        return result;
    }
}