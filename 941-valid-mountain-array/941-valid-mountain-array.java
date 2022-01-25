class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
        }
        if (max == arr[arr.length - 1]) {
            return false;
        }
        int prev = arr[0];
        boolean rise = true;
        for (int i = 1; i < arr.length; ++i) {
            if (prev >= arr[i] && rise || prev <= arr[i] && !rise) {
                return false;
            }
            if (arr[i] == max) {
                rise = !rise;
            }
            prev = arr[i];
        }
        return true;
    }
}