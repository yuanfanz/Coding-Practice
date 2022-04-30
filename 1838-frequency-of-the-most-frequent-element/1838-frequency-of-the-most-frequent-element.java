class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int ans = 1;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i), cnt = map.get(x);
            if (i > 0) {
                int p = k;
                for (int j = i - 1; j >= 0; j--) {
                    int y = list.get(j);
                    int diff = x - y;
                    if (p >= diff) {
                        int add = p / diff;
                        int min = Math.min(map.get(y), add);
                        p -= min * diff;
                        cnt += min;
                    } else {
                        break;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
// class Solution {
//     public int maxFrequency(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int i : nums) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
//         List<Integer> list = new ArrayList<>(map.keySet());
//         int max = 1;
//         Collections.sort(list);
//         for (int i = 0; i < list.size(); ++i) {
//             int cur = list.get(i);
//             int count = map.get(list.get(i));
//             if (i > 0) {
//                 int rem = k;
//                 for (int j = i - 1; j >= 0; --j) {
//                     int next = list.get(j);
//                     int diff = cur - next;
//                     if (rem >= diff) {
//                         int add = rem / diff;
//                         int min = Math.min(map.get(next), add);
//                         rem -= min * diff;
//                         count += min;
//                     } else {
//                         break;
//                     }
//                 }
//             }
//             max = Math.max(max, count);
//         }
//         return max;
//     }
// }