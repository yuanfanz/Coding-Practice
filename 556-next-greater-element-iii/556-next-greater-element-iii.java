class Solution {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        
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
        long result = Long.valueOf(String.valueOf(arr));
        return result <= Integer.MAX_VALUE && result > n ? (int) result : -1;
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