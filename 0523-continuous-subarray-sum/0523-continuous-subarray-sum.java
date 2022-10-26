class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // 这里value还是放index，和325一样，和560不同
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                // 之前出现过同样的余数
                // 且中间相隔的元素至少有两个
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else { // 为了保留最长的index，只有新的余数才放进去
                map.put(mod, i);
            }
        }
        return false;
    }
}