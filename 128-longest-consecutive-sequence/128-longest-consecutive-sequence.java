class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int val : set) {
            if (!set.contains(val - 1)) {
                int count = val;
                while (set.contains(count)) {
                    count++;
                }
                max = Math.max(max, count - val);
            }
        }
        return max;
    }
}