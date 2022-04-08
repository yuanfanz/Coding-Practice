class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > 0 && arr[i] * 2 > arr[arr.length - 1] 
                || arr[i] < 0 && arr[i] * 2 < arr[0]) continue;
            if (find(arr, i, arr[i] * 2)) {
                return true;
            }
        }
        return false;
    }
    private boolean find(int[] arr, int start, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] == target && mid != start) {
                return true;
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}