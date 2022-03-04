class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            
            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);
            
            if (end >= start) {
                list.add(new int[]{start, end});
            }
            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] cur : list) {
            result[index++] = cur;
        }
        return result;
    }
}