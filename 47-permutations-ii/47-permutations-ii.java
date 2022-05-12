class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        boolean[] visited = new boolean[n];
        dfs(result, new ArrayList<>(), nums, visited);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list,
                    int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(result, list, nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}