class DetectSquares {
    List<int[]> list;
    int[][] count;
    public DetectSquares() {
        list = new ArrayList<>();
        count = new int[1001][1001];
    }
    
    public void add(int[] point) {
        count[point[0]][point[1]]++;
        list.add(point);
    }
    
    public int count(int[] point) {
        int i = point[0];
        int j = point[1];
        int sum = 0;
        for (int[] cur : list) {
            int x = cur[0];
            int y = cur[1];
            if (x == i || Math.abs(x - i) != Math.abs(y - j)) {
                continue;
            }
            sum += count[i][y] * count[x][j];
        }
        return sum;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */