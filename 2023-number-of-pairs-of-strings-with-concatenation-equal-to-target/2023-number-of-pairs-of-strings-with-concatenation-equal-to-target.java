class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : nums) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (int i = 1; i < target.length(); ++i) {
            String left = target.substring(0, i);
            String right = target.substring(i, target.length());
            if (!left.equals(right)) {
                res += map.getOrDefault(left, 0) * map.getOrDefault(right, 0);
            } else {
                res += map.getOrDefault(left, 0) * (map.getOrDefault(left, 0) - 1);
            }
        }
        return res;
    }
}