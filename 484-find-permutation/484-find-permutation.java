class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            res[i] = i + 1;
        }
        int i = 1;
        while (i <= n) {
            if (s.charAt(i - 1) != 'I') {
                int j = i;
                while (i <= n && s.charAt(i - 1) == 'D') {
                    i++;
                }
                reverse(res, j - 1, i - 1);
            }
            i++;
        }
        return res;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}