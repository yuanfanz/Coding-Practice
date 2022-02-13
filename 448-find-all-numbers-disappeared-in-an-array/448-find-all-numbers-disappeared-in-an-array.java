class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            set.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}