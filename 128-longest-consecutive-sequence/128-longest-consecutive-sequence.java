class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i] - 1)) {
                int count = nums[i];
                while (set.contains(count)){
                    count++;
                }
                max = Math.max(max, count - nums[i]);
            }
        }
        return max;
    }
}