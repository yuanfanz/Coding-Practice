class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        
        int val = 0;
        for (int i = num.length - 1; i >= 0; --i) {
            val += num[i] + k % 10;
            result.add(0, val % 10);
            val /= 10;
            k /= 10;
        }
        while (k > 0) {
            val += k % 10;
            result.add(0, val % 10);
            k /= 10;
            val /= 10;
        }
        if (val > 0) {
            result.add(0, 1);
        }
        return result;
    }
}