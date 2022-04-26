class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int i = 0;
        int j = 1000000001;
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (isValid(bloomDay, mid, m, k)) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return j == 1000000001 ? -1 : j;
    }
    
    private boolean isValid(int[] bloomDay, int mid, int m, int k) {
        int count = 0;
        int cur = 0;
        for (int day : bloomDay) {
            if (day <= mid) {
                cur++;
            } else {
                cur = 0;
            }
            if (cur == k) {
                count++;
                cur = 0;
            }
        }
        return count >= m;
    }
}