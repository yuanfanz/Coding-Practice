class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        int max = 0;
        for (int next : map.keySet()) {
            max = Math.max(max, map.get(next));
        }
        for (int next : map.keySet()) {
            if (max == map.get(next)) {
                return next;
            }
        }
        return -1;
    }
}