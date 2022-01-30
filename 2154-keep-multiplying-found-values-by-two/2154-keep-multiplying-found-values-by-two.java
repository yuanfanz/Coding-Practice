class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int cur : nums) {
            set.add(cur);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}