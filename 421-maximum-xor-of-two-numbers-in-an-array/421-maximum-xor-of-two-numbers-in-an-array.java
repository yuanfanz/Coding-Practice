class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        for (int i = 31; i >= 0; --i) {
            mask = mask | (1 << i);
            
            Set<Integer> set = new HashSet<>();
            for (int cur : nums) {
                int leftPart = cur & mask;
                set.add(leftPart);
            }
            int greedyTry = max | (1 << i);
            for (int leftPart : set) {
                int anotherNum = leftPart ^ greedyTry;
                if (set.contains(anotherNum)) {
                    max = greedyTry;
                    break;
                }
            }
        }
        return max;
    }
}