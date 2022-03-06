class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while (i < command.length()) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
                i++;
            } else {
                if (command.charAt(i + 1) != ')') {
                    sb.append("al");
                    i += 4;
                } else {
                    sb.append("o");
                    i += 2;
                }
            }
        }
        return sb.toString();
    }
}