class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        while (left + 1 < arr.length && arr[left] <= arr[left + 1]) {
            left++;
        }
        int right = arr.length - 1;
        while (right - 1 >= 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        // System.out.println(left);
        // System.out.println(right);
        
        if (left > right) return 0;
        
        int min = Math.min(n - left - 1, right);
        // System.out.println(min);
        
        for (int i = 0; i <= left; ++i){
            int leftBound = findLeftBound(arr, arr[i], right);
            if (leftBound != -1) {
                // System.out.print(arr[i] + " ");
                // System.out.println(leftBound);
                min = Math.min(min, leftBound - i - 1);
            }
        }
        
        // int rightBound = findRightBound(arr, left, right);
        // System.out.println("+++");
        // if (rightBound != -1) {
        //     min = Math.min(min, right - rightBound + 1);
        // System.out.println(min);
        // }
        
        return Math.max(min, 0);
    }
    
    private int findRightBound(int[] arr, int left, int right) {
        int target = arr[right];
        int i = 0;
        int j = left;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0) return -1;
        return j;
    }
    
    private int findLeftBound(int[] arr, int target, int right) {
        int i = right;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i > arr.length - 1) return -1;
        return i;
    }
}