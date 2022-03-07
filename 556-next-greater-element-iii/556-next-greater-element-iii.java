class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] - '0' < arr[i + 1] - '0') {
                break;
            }
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] - '0' <= arr[i] - '0') {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1);
        long res = Long.valueOf(String.valueOf(arr));
        return res > Integer.MAX_VALUE || res <= n ? -1 : (int) res;
    }
    private void reverse(char[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}