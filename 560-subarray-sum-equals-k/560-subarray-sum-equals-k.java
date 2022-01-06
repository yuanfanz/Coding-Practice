class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0;
        int total = 0;
        for (int i = 0; i < nums.length; ++i) {
            presum += nums[i];
            if (map.containsKey(presum - k)) {
                total += map.get(presum - k);
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return total;
    }
}