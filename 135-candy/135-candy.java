class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < n; ++i) {
            int prev = i - 1;
            int next = i + 1;
            if (prev >= 0 && ratings[i] > ratings[prev]) {
                while (res[i] <= res[prev]) {
                    res[i]++;
                }
            }
            if (next < n && ratings[i] > ratings[next]) {
                while (res[i] <= res[next]) {
                    res[i]++;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            int prev = i - 1;
            int next = i + 1;
            if (prev >= 0 && ratings[i] > ratings[prev]) {
                while (res[i] <= res[prev]) {
                    res[i]++;
                }
            }
            if (next < n && ratings[i] > ratings[next]) {
                while (res[i] <= res[next]) {
                    res[i]++;
                }
            }
        }
        int sum = 0;
        for (int i : res) {
            sum += i;
        }
        return sum;
    }
}