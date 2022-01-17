class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int presum = 0;
        for (int i = 0; i < nums.length; ++i) {
            presum += nums[i];
            int rem = presum % k;
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                if (i - index > 1) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }
}