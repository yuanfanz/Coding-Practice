class Solution {
    public String convert(String s, int numRows) {
        char[] arr = s.toCharArray();
        int totalLen = arr.length;
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            sbArr[i] = new StringBuilder();
        }
        int index = 0;
        while (index < totalLen) {
            // first, goes down
            for (int i = 0; i < numRows && index < totalLen; ++i) {
                sbArr[i].append(arr[index++]);
            }
            // then go up obliquely
            for (int i = numRows - 2; i >= 1 && index < totalLen; --i) {
                sbArr[i].append(arr[index++]);
            }
        }
        for (int i = 1; i < sbArr.length; ++i) {
            sbArr[0].append(sbArr[i]);
        }
        return sbArr[0].toString();
    }
}