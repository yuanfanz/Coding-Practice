class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> list = new ArrayList<>();
        for (int num : nums) {
            StringBuilder sb = new StringBuilder();
            char[] arr = String.valueOf(num).toCharArray();
            for (char ch : arr) {
                sb.append(mapping[ch - '0']);
            }
            list.add(new int[]{Integer.valueOf(sb.toString()), num});
        }
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        int[] result = new int[nums.length];
        int index = 0;
        for (int[] cur : list) {
            result[index++] = cur[1];
        }
        return result;
    }
}