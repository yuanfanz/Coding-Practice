class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int prev = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (prev + 1 == nums[i]) {
                prev = nums[i];
                continue;
            }
            result.add(formRange(start, prev));
            prev = nums[i];
            start = nums[i];
        }
        result.add(formRange(start, prev));
        return result;
    }
    private String formRange(int low, int high) {
        if (low == high) {
            return low + "";
        }
        return low + "->" + high;
    }
}