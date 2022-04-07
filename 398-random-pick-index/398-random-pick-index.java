class Solution {
    Map<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */