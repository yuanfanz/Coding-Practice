class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        
        int i = 0;
        int n = warehouse.length;
        int j = n - 1;
        int[] cur = new int[n];
        cur[0] = warehouse[0];
        int min = cur[0];
        for (int k = 1; k < n; ++k) {
            min = Math.min(min, warehouse[k]);
            cur[k] = min;
        }
        while (j >= 0 && i < boxes.length) {
            if (boxes[i] <= cur[j]) {
                i++;
                j--;
            } else {
                j--;
            }
        }
        return i;
    }
}