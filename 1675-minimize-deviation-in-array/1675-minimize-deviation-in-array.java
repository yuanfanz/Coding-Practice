class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 0) {
                set.add(nums[i]);
            } else {
                set.add(nums[i] * 2);
            }
            
        }
        int min = Integer.MAX_VALUE;
        while (true) {
            int max = set.last();
            min = Math.min(min, max - set.first());
            if (max % 2 == 0) {
                set.remove(max);
                set.add(max / 2);
            } else {
                break;
            }
        }
        return min;
    }
}