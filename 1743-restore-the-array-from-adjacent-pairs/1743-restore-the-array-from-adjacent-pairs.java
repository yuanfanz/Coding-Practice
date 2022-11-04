class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] nums : adjacentPairs) {
            int u = nums[0];
            int v = nums[1];
            map.putIfAbsent(u, new HashSet<>());
            map.putIfAbsent(v, new HashSet<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        Set<Integer> visited = new HashSet<>();//控制元素重复访问的set
        int start = 0;//处理当前的点
        int[] res = new int[n + 1];//结果数组
        int index = 0;
        for (Integer curr : map.keySet()) {
            if (map.get(curr).size() == 1) {//找一个size为1的
                start = curr;
                visited.add(start);
                res[index++] = start;
                break;
            }
        }
        while (visited.size() < n + 1) {
            for (int next : map.get(start)) {//遍历当前点的邻居节点
                if (!visited.contains(next)) {
                    visited.add(next);
                    res[index++] = next;
                    start = next;
                    break;
                }
            }
        }
        return res;
    }
}