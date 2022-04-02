class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        int count = 0;
        for (int i : arr1) {
            int left = i - d;
            int right = i + d;
            Set<Integer> subset = set.subSet(left, right + 1);
            if (subset.size() == 0) {
                count++;
            }
        }
        return count;
    }
}