class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        // even is true
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                // even
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);
        int[] result = new int[nums.length];
        
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i % 2 == 0) {
                result[i] = even.get(left++);
            } else {
                result[i] = odd.get(right++);
            }
            
        }
        return result;
    }
}