class Solution {
    public int maximumTop(int[] nums, int k) {
        if (k == 0) return nums[0];
        if (nums.length == 1) {
            if (k % 2 == 1) return -1;
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        return dfs(nums, k, 0, map);
    }
    private int dfs(int[] nums, int k, int index, Map<Integer, Integer> map) {
        if (map.containsKey(k)) return map.get(k);
        if (index >= nums.length) return -1;
        
        int cur = nums[index];
        int max = dfs(nums, k - 1, index + 1, map);
        if (k > 1) {
            max = Math.max(max, cur);
        } else if (k == 0) {
            max = cur;
        } else if (k == 1 && index + 1 < nums.length) {
            max = Math.max(max, nums[index + 1]);
        }
        map.put(k, max);
        return max;
    }
}