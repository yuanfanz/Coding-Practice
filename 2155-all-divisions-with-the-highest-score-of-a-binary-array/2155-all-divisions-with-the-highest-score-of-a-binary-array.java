class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int n = nums.length;
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + nums[i];
        }
        int max = 0;
        int[] value = new int[nums.length + 1];
        for (int i = 0; i <= n; ++i) {
            int left = i - presum[i];
            int right = presum[n] - presum[i];
            int score = left + right;
            value[i] = left + right;
            max = Math.max(max, left + right);
        }
        for (int i = 0; i < value.length; ++i) {
            if (max == value[i]) {
                result.add(i);
            }
        }
        return result;
    }
}