class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i] - 1)) {
                int len = 0;
                int num = nums[i];
                while (set.contains(num++)) {
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}