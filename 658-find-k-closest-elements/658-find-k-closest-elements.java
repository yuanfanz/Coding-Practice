class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int i = 0;
        int j = arr.length - k;
        
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int cur = i; cur < i + k; ++cur) {
            result.add(arr[cur]);
        }
        return result;
    }
}