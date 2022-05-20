class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        
        int i = 0;
        int j = n - 1;
        
        while (i < j) {
            int pivot = partition(points, i, j);
            if (pivot == k) {
                break;
            } else if (pivot < k) {
                i = pivot + 1;
            } else {
                j = pivot - 1;
            }
        }
        int[][] res = new int[k][2];
        for (int m = 0; m < n && k > 0; ++m) {
            res[m] = points[m];
            k--;
        }
        return res;
    }
    
    private int partition(int[][] points, int i, int j) {
        int[] pivot = points[i];
        while (i < j) {
            while (i < j && getDistance(pivot) <= getDistance(points[j])) {
                j--;
            }
            points[i] = points[j];
            while (i < j && getDistance(pivot) >= getDistance(points[i])) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = pivot;
        return i;
    }
    
    private int getDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
}












