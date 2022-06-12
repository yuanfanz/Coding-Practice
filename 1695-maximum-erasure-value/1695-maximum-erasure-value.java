class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        int j = 0;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && !set.contains(nums[j])) {
                set.add(nums[j]);
                sum += nums[j++];
            }
            max = Math.max(max, sum);
            set.remove(nums[i]);
            sum -= nums[i];
        }
        return max;
    }
}