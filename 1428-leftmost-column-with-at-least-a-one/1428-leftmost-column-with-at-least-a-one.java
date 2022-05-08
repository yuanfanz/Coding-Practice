
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);
        
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (check(binaryMatrix, mid, m)) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (i >= n) return -1;
        return i;
    }
    private boolean check(BinaryMatrix binaryMatrix, int j, int total) {
        int i = 0;
        while (i < total) {
            if (binaryMatrix.get(i, j) == 1) {
                return true;
            }
            i++;
        }
        return false;
    }
}

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */