class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            list.add(new int[]{difficulty[i], profit[i]});
        }
        int[][] arr = new int[n][2];
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int diff = list.get(0)[0];
        int max = list.get(0)[1];
        int index = 0;
        arr[index++] = new int[]{diff, max};
        for (int i = 1; i < n; ++i) {
            int[] cur = list.get(i);
            max = Math.max(max, cur[1]);
            arr[index++] = new int[]{cur[0], max};
        }
        
        int sum = 0;
        for (int i = 0; i < worker.length; ++i) {
            int target = worker[i];
            sum += search(arr, target);
        }
        return sum;
    }
    private int search(int[][] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid][0] == target) {
                i = mid + 1;
            } else if (arr[mid][0] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (j < 0) return 0;
        return arr[j][1];
    }
}













