class Solution {
    public String getSmallestString(int n, int k) {
        if (n * 26 < k) {
            return "";
        }
        char[] arr = new char[n];
        Arrays.fill(arr, 'a');
        int index = n - 1;
        k -= n;
        while (k > 0 && index >= 0) {
            int cur = Math.min(25, k);
            char ch = (char) (cur + 'a');
            k -= cur;
            arr[index--] = ch;
        }
        return String.valueOf(arr);
    }
}