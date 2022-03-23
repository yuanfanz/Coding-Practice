class Solution {
    public int findGCD(int[] nums) {
        int p = Integer.MAX_VALUE;
        int q = Integer.MIN_VALUE;
        
        for (int i : nums) {
            p = Math.min(p, i);
            q = Math.max(q, i);
        }
        
        return gcd(p, q);
    }
    
    private int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}