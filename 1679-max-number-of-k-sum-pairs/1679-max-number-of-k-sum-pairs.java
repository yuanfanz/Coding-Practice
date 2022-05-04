class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int cur : nums) {
            int target = k - cur;
            if (map.containsKey(target)) {
                count++;
                int val = map.get(target) - 1;
                if (val > 0) {
                    map.put(target, val);
                } else {
                    map.remove(target);
                }
            } else {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        return count;
    }
}