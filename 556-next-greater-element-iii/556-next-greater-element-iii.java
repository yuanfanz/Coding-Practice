class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (j > i && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i + 1);
        long num = Long.valueOf(String.valueOf(arr));
        return num > n && num <= Integer.MAX_VALUE ? (int) num : -1;
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
        char ch = arr[i];
        arr[i] = arr[j];
        arr[j] = ch;
    }
}