class Solution {
    public int fixedPoint(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == mid) {
                j = mid - 1;
            } else if (arr[mid] < mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (i >= arr.length || arr[i] != i) {
            return -1;
        }
        return i;
    }
}