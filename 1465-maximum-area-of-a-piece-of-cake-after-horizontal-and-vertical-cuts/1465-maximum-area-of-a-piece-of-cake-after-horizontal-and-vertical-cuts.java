class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = (int) Math.pow(10, 9) + 7;
        
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int prev = horizontalCuts[0];
        row.add(horizontalCuts[0]);
        for (int i = 1; i < horizontalCuts.length; ++i) {
            row.add(horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        row.add(h - prev);
        
        prev = verticalCuts[0];
        col.add(verticalCuts[0]);
        for (int i = 1; i < verticalCuts.length; ++i) {
            col.add(verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        col.add(w - prev);
        Collections.sort(row, Collections.reverseOrder());
        Collections.sort(col, Collections.reverseOrder());
        
        long max = 0;
        int i = 0;
        int j = 0;
        // while (i < row.size() && j < col.size()) {
        //     long rowNum = (long) row.get(i);
        //     long colNum = (long) col.get(j);
        //     long area = rowNum * colNum;
        //     max = Math.max(max, area);
        //     if (rowNum > colNum) {
        //         j++;
        //     } else {
        //         i++;
        //     }
        // }
        // return (int) (max % mod);
        long area = ((long)row.get(0) * (long)col.get(0));
        return (int) (area % mod);
    }
}














