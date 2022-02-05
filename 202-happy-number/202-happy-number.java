class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isValid(n, set);
    }
    private boolean isValid(int n, Set<Integer> set) {
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            int num = 0;
            while (n > 0) {
                num += (n % 10) * (n % 10);
                n /= 10;
            }
            // System.out.println(num);
            return isValid(num, set);
        }
        return true;
    }
}