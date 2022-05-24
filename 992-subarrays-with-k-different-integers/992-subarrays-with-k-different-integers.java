class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (k == 0) return 0;
        
        return getSubArr(nums, k) - getSubArr(nums, k - 1);
    }
    
    private int getSubArr(int[] nums, int k) {
        int n = nums.length;
        
        int i = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; ++j) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (i < n && map.size() > k) {
                int val = map.get(nums[i]);
                val--;
                if (val == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], val);
                }
                i++;
            }
            if (map.size() <= k) {
                count += j - i + 1;
            }
        }
        return count;
    }
}