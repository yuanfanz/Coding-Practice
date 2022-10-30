class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int max = 0;
        
        int i = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j = 0; j < nums.length; ++j) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            
            int diff = map.lastKey() - map.firstKey();
            while (i <= j && diff > limit) {
                int freq = map.get(nums[i]);
                freq--;
                if (freq == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], freq);
                }
                diff = map.lastKey() - map.firstKey();
                i++;
            }
            
            max = Math.max(max, (j - i + 1));
        }
        return max;
    }
}