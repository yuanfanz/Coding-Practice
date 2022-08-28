class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                int index = i - j;
                List<Integer> list = map.getOrDefault(index, new ArrayList<>());
                list.add(mat[i][j]);
                map.put(index, list);
            }
        }
        for (int index : map.keySet()) {
            Collections.sort(map.get(index));
            indexMap.put(index, 0);
        }
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                int index = i - j;
                List<Integer> list = map.get(index);
                int cur = indexMap.get(index);
                res[i][j] = list.get(cur);
                indexMap.put(index, cur + 1);
            }
        }
        return res;
    }
}