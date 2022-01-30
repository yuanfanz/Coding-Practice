class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        int n = nums.length;
        int[] pre = new int[n + 1];
        pre[0] = 0;
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        // zeros to left: i - pre[i];
        // ones to right: pre[n] - pre[i];
        
        int max = 0;
        int[] value = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            int val = i - pre[i] + pre[n] - pre[i];
            value[i] = val;
            max = Math.max(max, val);
        }
        for (int i = 0; i <= n; ++i) {
            if (max == value[i]) {
                result.add(i);
            }
        }
        return result;
    }
}