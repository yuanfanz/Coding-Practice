class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < nums.length) {
            int cur = nums[i];
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }
            result.add(formRange(cur, nums[i++]));
        }
        return result;
    }
    private String formRange(int low, int high) {
        if (low == high) {
            return low + "";
        } else {
            return low + "->" + high;
        }
    }
}