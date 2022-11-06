class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int i = 0;
        long max = 0;
        long sum = 0;
        for (int j = 0; j < nums.length; ++j) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            sum += nums[j];
            if ((j - i + 1) > k) {
                int pop = nums[i];
                sum -= nums[i];
                int freq = map.get(pop);
                freq--;
                if (freq == 0) {
                    map.remove(pop);
                } else {
                    map.put(pop, freq);
                }
                i++;
            }
            if (map.size() == k) {
                max = Math.max(max, sum);
            }
            
        }
        return max;
    }
}