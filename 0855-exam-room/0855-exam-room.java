class ExamRoom {
    
    private PriorityQueue<int[]> pq;
    private int N;
    
    public ExamRoom(int n) {
        N = n;
        pq = new PriorityQueue<>((a, b) -> {
            int posA = getPos(a);
            int posB = getPos(b);
            if (posA != posB) {
                return posB - posA;
            } else {
                return a[0] - b[0];
            }
        });
        pq.offer(new int[]{-1, N});
    }
    
    public int seat() {
        int res = 0;
        // try to get the longest segment
        int[] arr = pq.poll();
        if (arr[0] == -1) { // no one on left
            res = 0;
        } else if (arr[1] == N) { // no one on right
            res = N - 1;
        } else {
            res = arr[0] + (arr[1] - arr[0]) / 2;
        }
        pq.offer(new int[]{arr[0], res});
        pq.offer(new int[]{res, arr[1]});
        return res;
    }
    
    public void leave(int p) {
        int[] left = null;
        int[] right = null;
        for (int[] arr : pq) {
            if (arr[1] == p) {
                left = arr;
            }
            if (arr[0] == p) {
                right = arr;
            }
        }
        pq.remove(left);
        pq.remove(right);
        pq.offer(new int[]{left[0], right[1]});
    }
    
    private int getPos(int[] arr) {
        int pos = 0;
        if (arr[0] == -1) {
            pos = arr[1];
        } else if (arr[1] == N) {
            pos = N - 1 - arr[0];
        } else {
            pos = (arr[1] - arr[0]) / 2;
        }
        return pos;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */












