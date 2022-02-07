class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return helper(n, set);
    }
    private boolean helper(int n, Set<Integer> set) {
        if (n == 1) {
            return true;
        }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int sum = 0;
            int num = n;
            while (num > 0) {
                int rem = num % 10;
                sum += rem * rem;
                num /= 10;
            }
            return helper(sum, set);
    }
}