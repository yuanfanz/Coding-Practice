class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        
        int i = 0;
        int res = 0;
        while (i < boxTypes.length && truckSize > 0) {
            int num = boxTypes[i][0];
            int unit = boxTypes[i++][1];
            int min = Math.min(num, truckSize);
            res += min * unit;
            truckSize -= num;
        }
        return res;
    }
}