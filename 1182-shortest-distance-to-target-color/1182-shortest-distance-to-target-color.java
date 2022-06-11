class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; ++i) {
            List<Integer> list = map.getOrDefault(colors[i], new ArrayList<>());
            list.add(i);
            map.put(colors[i], list);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] cur : queries) {
            if (!map.containsKey(cur[1])) {
                result.add(-1);
                continue;
            }
            int index = helper(map.get(cur[1]), cur[0]);
            // System.out.println(index);
            result.add(Math.abs(cur[0] - index));
        }
        return result;
    }
    private int helper(List<Integer> list, int target) {
        int min = Integer.MAX_VALUE;
        int close = 0;
        int i = 0;
        int j = list.size() - 1;
        // if (target == 1) {
        //     print(list);
        // }
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (min > Math.abs(list.get(mid) - target)) {
                close = list.get(mid);
                min = Math.abs(list.get(mid) - target);
            }
            if (list.get(mid) == target) {
                return list.get(mid);
            } else if (list.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return close;
    }
    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}












