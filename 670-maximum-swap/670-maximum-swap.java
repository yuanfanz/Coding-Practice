class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int[] bucket = new int[10];
        
        for (int i = 0; i < arr.length; ++i) {
            char ch = arr[i];
            bucket[ch - '0'] = i;
        }
        for (int i = 0; i < arr.length; ++i) {
            char ch = arr[i];
            int cur = ch - '0';
            for (int j = 9; j > cur; --j) {
                if (bucket[j] > i) {
                    char tmp = arr[bucket[j]];
                    arr[bucket[j]] = ch;
                    arr[i] = tmp;
                    return Integer.valueOf(String.valueOf(arr));
                }
            }
        }
        return num;
    }
}