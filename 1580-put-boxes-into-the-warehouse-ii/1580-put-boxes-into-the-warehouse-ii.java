class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        int n = warehouse.length;
        
        int[] max = new int[n];
        max[0] = warehouse[0];
        int min = warehouse[0];
        for (int i = 1; i < n; ++i) {
            min = Math.min(min, warehouse[i]);
            max[i] = min;
        }
        max[n - 1] = Math.max(warehouse[n - 1], max[n - 1]);
        min = warehouse[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            min = Math.min(min, warehouse[i]);
            max[i] = Math.max(max[i], min);
        }
        
        Arrays.sort(boxes);
        Arrays.sort(max);
        int i = 0;
        int j = 0;
        while (i < boxes.length && j < max.length) {
            if (boxes[i] <= max[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }
}