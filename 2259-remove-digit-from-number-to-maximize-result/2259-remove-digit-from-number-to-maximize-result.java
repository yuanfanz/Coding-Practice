class Solution {
    public String removeDigit(String number, char digit) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < number.length(); ++i) {
            if (number.charAt(i) == digit) {
                res = i;
                if (i == number.length() - 1) {
                    res = i;
                    break;
                } else {
                    if (number.charAt(i + 1) - '0' > digit - '0') {
                        res = i;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder(number);
        sb.deleteCharAt(res);
        return sb.toString();
        
    }
}