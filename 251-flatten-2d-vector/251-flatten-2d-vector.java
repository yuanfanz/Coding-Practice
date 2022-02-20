class Vector2D {
    int[][] vec;
    int i = 0;
    int j = 0;
    public Vector2D(int[][] vec) {
        this.vec = vec;
    }
    
    public int next() {
        if (hasNext()) {
            return vec[i][j++];
        } else {
            return -1;
        }
    }
    
    public boolean hasNext() {
        while (i < vec.length && j == vec[i].length) {
            i++;
            j = 0;
        }
        return i < vec.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */