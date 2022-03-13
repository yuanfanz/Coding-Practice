class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; --i) {
            carry = digits[i] + carry;
            digits[i] = carry % 10;
            carry /= 10;
            if (carry == 0) break;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i <= digits.length; ++i) {
                result[i] = digits[i - 1];
            }
            return result;
        }
        return digits;
    }
}