class Solution {
    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int len = mat.length;
        for (int[] nums : mat) {
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            if (len == map.get(key)) {
                if (res > key) {
                    res = key;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}