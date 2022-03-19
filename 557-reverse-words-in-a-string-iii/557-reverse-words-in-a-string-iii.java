class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; ++i) {
            sb.append(reverse(strs[i]));
            if (i < strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    private String reverse(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(arr);
    }
}