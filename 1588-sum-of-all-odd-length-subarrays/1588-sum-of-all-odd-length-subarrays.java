class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < arr.length; ++i) {
            int start = n - i;
            int end = i + 1;
            int total = start * end;
            int odd = (total + 1) / 2;
            result += odd * arr[i];
        }
        return result;
    }
}