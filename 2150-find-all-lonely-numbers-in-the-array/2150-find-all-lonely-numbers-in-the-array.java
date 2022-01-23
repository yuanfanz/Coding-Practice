class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> deleteSet = new HashSet<>();
        Set<Integer> select = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                deleteSet.add(nums[i]);
            }
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(nums[i] - 1) && !set.contains(nums[i] + 1)) {
                select.add(nums[i]);
            }
        }
        for (int next : select) {
            if (!deleteSet.contains(next)) {
                result.add(next);
            }
        }
        return result;
    }
}