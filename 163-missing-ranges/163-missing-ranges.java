class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }
        
        if (lower < nums[0]) {
            result.add(formRange(lower, nums[0] - 1));
        }
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] < nums[i + 1] - 1) {
                result.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
            i++;
        }
        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }
    private String formRange(int low, int high) {
        if (low == high) {
            return low + "";
        }
        return low + "->" + high;
    }
}