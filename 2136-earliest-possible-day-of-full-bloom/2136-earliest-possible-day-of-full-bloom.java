class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < growTime.length; ++i) {
            list.add(new int[]{growTime[i], i});
        }
        Collections.sort(list, (a, b) -> b[0] - a[0]);
        int max = 0;
        int plant = 0;
        for (int[] cur : list) {
            int grow = cur[0];
            int index = cur[1];
            int total = grow + plantTime[index] + plant;
            max = Math.max(max, total);
            plant += plantTime[index];
        }
        return max;
    }
}