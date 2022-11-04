

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] targetArr = String.valueOf(n).toCharArray();
        int result = 0;
        int targetLen = targetArr.length;
        int digitLen = digits.length;
        // 先对【非最高位】的其他位，可组装的数字进行统计
        for (int i = 1; i < targetLen; i++) {
            result += Math.pow(digitLen, i); 
        }
        for (int i = 0; i < targetLen; i++) {
            boolean compareNext = false; // 是否需要对比下一个数字
            for (String digit : digits) {
                char dc = digit.charAt(0); // 将String转换为char
                if (dc < targetArr[i]) {
                    result += Math.pow(digitLen, targetLen - i - 1);
                } else {
                    if (dc == targetArr[i]) compareNext = true; break;
                }
            }
            if (!compareNext) return result;
        }
        // 如果到最后1位依然满足compareNext，因为最后1位无法再向后对比了，所以最终结果+1
        return ++result;
    }
}