class Solution {
    public int maximumGood(int[][] statements) {
        int max = 0;
        int n = statements.length;
        
        for (int i = 1; i < 1 << n; ++i) {
            boolean conflict = false;
            for (int j = 0; j < n; ++j) {
                if (conflict) break;
                // only check good people statements (j's statements)
                if (((i >> j) & 1) == 1) {
                    // check all statements made by good person: j
                    for (int k = 0; k < n; ++k) {
                        if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) {
                            conflict = true;
                            break;
                        }
                    }
                }
            }
            if (conflict) continue;
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (((i >> j) & 1) == 1) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}