class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int i = 0;
        int j = points.length - 1;
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
        int[][] result = new int[k][2];
        int index = 0;
        for (i = 0; i < k; ++i) {
            result[index++] = points[i];
        }
        return result;
    }
    private int partition(int[][] points, int i, int j) {
        int[] pivot = points[i];
        while (i < j) {
            while (i < j && getDistance(points[j]) >= getDistance(pivot)) {
                j--;
            }
            points[i] = points[j];
            while (i < j && getDistance(points[i]) <= getDistance(pivot)) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = pivot;
        return i;
    }
    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}