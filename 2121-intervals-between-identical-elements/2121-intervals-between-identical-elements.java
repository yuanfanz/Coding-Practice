class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            long[] left = new long[list.size()];
            long[] right = new long[list.size()];
            for (int i = 1; i < list.size(); ++i) {
                left[i] = left[i - 1] + i * (list.get(i) - list.get(i - 1));
            }
            for (int i = list.size() - 2; i >= 0; --i) {
                right[i] = right[i + 1] + (list.size() - i - 1) * (list.get(i + 1) - list.get(i));
            }
            for (int i = 0; i < list.size(); ++i) {
                res[list.get(i)] = left[i] + right[i];
            }
        }
        return res;
    }
}