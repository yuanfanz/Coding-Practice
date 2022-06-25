class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        
        int[] pos = new int[10];
        for (int i = 0; i < arr.length; ++i) {
            pos[arr[i] - '0'] = i;
        }
        for (int i = 0; i < arr.length; ++i) {
            int curNum = arr[i] - '0';
            for (int next = 9; next > curNum; --next) {
                // there is number num after index i
                if (pos[next] > i) {
                    char tmp = arr[i];
                    arr[i] = arr[pos[next]];
                    arr[pos[next]] = tmp;
                    return Integer.valueOf(String.valueOf(arr));
                }
            }
        }
        return num;
    }
}