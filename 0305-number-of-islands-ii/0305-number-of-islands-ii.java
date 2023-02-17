class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] cur : positions) {
            if (grid[cur[0]][cur[1]] == 1) {
                result.add(result.get(result.size() - 1));
                continue;
            }
            grid[cur[0]][cur[1]] = 1;
            uf.count++;
            for (int[] dir : dirs) {
                int row = cur[0] + dir[0];
                int col = cur[1] + dir[1];
                if (row < 0 || col < 0 || row >= m || col >= n
                   || grid[row][col] == 0) {
                    continue;
                }
                uf.union(row * n + col, cur[0] * n + cur[1]);
            }
            result.add(uf.count);
        }
        return result;
    }
    class UnionFind{
        int[] parent;
        int count;
        int[] size;
        public UnionFind(int m, int n) {
            int total = m * n;
            parent = new int[total];
            size = new int[total];
            count = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int index = i * n + j;
                    parent[index] = index;
                    size[index] = 1;
                }
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
    }
}