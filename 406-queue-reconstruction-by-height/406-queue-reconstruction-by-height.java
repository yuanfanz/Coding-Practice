class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        
        int n = people.length;
        int[][] result = new int[n][2];
        for (int[] cur : result) {
            cur[0] = -1;
            cur[0] = -1;
        }
        for (int i = 0; i < n; ++i) {
            int[] cur = people[i];
            int front = cur[1];
            int j = 0;
            while (j < n) {
                // -1 means taller person will stand there
                if (result[j][0] == -1 || result[j][0] >= cur[0]) {
                    if (front == 0) break;
                    front--;
                }
                j++;
            }
            result[j] = cur;
        }
        return result;
    }
}