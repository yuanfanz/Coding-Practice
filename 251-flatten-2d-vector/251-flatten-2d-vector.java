class Vector2D {
    private Iterator<int[]> rowIter;
    private Iterator<Integer> colIter;
    public Vector2D(int[][] vec) {
        rowIter = Arrays.stream(vec).iterator();
        if (rowIter.hasNext()) {
            colIter = Arrays.stream(rowIter.next()).iterator();
        }
    }
    
    public int next() {
        if (!hasNext()) {
            return -1;
        } else {
            return colIter.next();
        }
    }
    
    public boolean hasNext() {
        if (colIter == null) {
            return false;
        }
        while (!colIter.hasNext() && rowIter.hasNext()) {
            colIter = Arrays.stream(rowIter.next()).iterator();
        }
        return colIter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */