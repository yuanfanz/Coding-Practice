class Solution {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            res[i] = i + 1;
        }
        int i = 1;
        while (i <= n) {
            // swap when D happens
            if (s.charAt(i - 1) == 'D') {
                int j = i;
                while (i <= n && s.charAt(i - 1) == 'D') {
                    i++;
                }
                swap(res, j - 1, i - 1);
            }
            i++;
        }
        return res;
    }
    private void swap(int[] res, int i, int j) {
        while (i < j) {
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
            i++;
            j--;
        }
    }
}