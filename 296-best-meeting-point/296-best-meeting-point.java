class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }
        return getMin(rowList) + getMin(colList);
    }
    
    private int getMin(List<Integer> list) {
        Collections.sort(list);
        
        int i = 0;
        int j = list.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += (list.get(j--) - list.get(i++));
        }
        return sum;
    }
}


















