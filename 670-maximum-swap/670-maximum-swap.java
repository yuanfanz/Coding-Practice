class Solution {
    public int maximumSwap(int num) {
        int[] pos = new int[10];
        
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); ++i) {
            pos[str.charAt(i) - '0'] = i;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            int cur = arr[i] - '0';
            for (int j = 9; j > cur; --j) {
                if (pos[j] > i) {
                    char tmp = arr[i];
                    arr[i] = (char) (j + '0');
                    arr[pos[j]] = tmp;
                    return Integer.valueOf(String.valueOf(arr));
                }
            }
        }
        return num;
    }
}