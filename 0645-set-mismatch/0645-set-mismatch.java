class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                res[0] = num;
            }
        }
        for (int i = 1; i <= nums.length; ++i) {
            if (!set.contains(i)) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}