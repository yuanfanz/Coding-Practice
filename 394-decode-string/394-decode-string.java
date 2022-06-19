class Solution {
    public String decodeString(String s) {
        return getString(s, 1);
    }
    
    private String getString(String s, int num) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        int prev = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int count = 1;
                int start = i + 1;
                int end = i + 1;
                while (end < s.length() && count > 0) {
                    if (s.charAt(end) == '[') {
                        count++;
                    } else if (s.charAt(end) == ']') {
                        count--;
                        if (count == 0) break;
                    }
                    end++;
                }
                if (prev == 0) prev = 1;
                sb.append(getString(s.substring(start, end), prev));
                i = end + 1;
                prev = 0;
            } else if (Character.isDigit(s.charAt(i))) {
                prev = prev * 10 + s.charAt(i) - '0';
                i++;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        String once = sb.toString();
        String result = "";
        for (int j = 0; j < num; ++j) {
            result = result + once;
        }
        return result;
    }
}