class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        
        for (int i = 0; i < l.length; ++i) {
            result.add(isValid(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        }
        return result;
    }
    private boolean isValid(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(nums.length);
        if (nums.length < 3) return true;
        for (int i = 2; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] != nums[i - 1] - nums[i - 2]) return false;
        }
        return true;
    }
}