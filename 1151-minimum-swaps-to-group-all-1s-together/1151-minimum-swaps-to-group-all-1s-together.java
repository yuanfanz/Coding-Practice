class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for (int i : data) {
            ones += i;
        }
        int i = 0;
        int sum = 0;
        int min = data.length;
        for (int j = 0; j < data.length; ++j) {
            sum += data[j];
            while (j - i + 1 > ones) {
                if (data[i] == 1) sum--;
                i++;
            }
            if (j - i + 1 == ones) {
                min = Math.min(ones - sum, min);
            }
        }
        return min;
    }
}