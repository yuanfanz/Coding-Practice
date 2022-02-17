class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(result, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}