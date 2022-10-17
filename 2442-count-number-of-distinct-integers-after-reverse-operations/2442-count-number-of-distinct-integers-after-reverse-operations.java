class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();
    }
    
    public int reverse(int x) {
        int base = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (base > Integer.MAX_VALUE/10 || base == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            if (base < Integer.MIN_VALUE/10 || base == Integer.MIN_VALUE && pop < -8) {
                return 0;
            }
            base = base * 10 + pop;
        }
        return base;
    }
}