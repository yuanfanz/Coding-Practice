class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for (int i = 31; i >= 0; --i) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int cur : nums) {
                int left = cur & mask;
                set.add(left);
            }
            int tmp = max | (1 << i);
            for (int left : set) {
                int anotherNum = left ^ tmp;
                if (set.contains(anotherNum)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}