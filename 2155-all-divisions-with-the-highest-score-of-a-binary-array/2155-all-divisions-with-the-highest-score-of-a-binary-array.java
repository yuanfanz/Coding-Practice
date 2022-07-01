class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        
        int[] presum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; ++i) {
            int left = i - presum[i];
            int right = presum[n] - presum[i];
            int sum = left + right;
            if (sum > max) {
                max = sum;
                list = new ArrayList<>();
                list.add(i);
            } else if (sum == max) {
                list.add(i);
            }
        }
        return list;
    }
}