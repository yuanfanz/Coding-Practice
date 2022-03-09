class Vector2D {
    int[][] arr;
    int i;
    int j;
    public Vector2D(int[][] vec) {
        arr = vec;
        i = 0;
        j = 0;
    }
    
    public int next() {
        if (hasNext()) {
            return arr[i][j++];
        }
        return -1;
    }
    
    public boolean hasNext() {
        while (i < arr.length && j == arr[i].length) {
            i++;
            j = 0;
        }
        return i < arr.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */