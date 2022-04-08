class Solution {
    public String getSmallestString(int n, int k) {
        char[] arr = new char[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = 'a';
            k -= 1;
        }
        int i = arr.length - 1;
        while (k > 0 && i >= 0) {
            if (k >= 25) {
                arr[i] = 'z';
                k -= 25;
                i--;
            } else {
                arr[i] = (char) (k + arr[i]);
                break;
            }
        }
        return String.valueOf(arr);
    }
}