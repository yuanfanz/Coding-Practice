class Solution {
    public String reformatDate(String date) {
        String[] months = new String[]{"Jan", "Feb", "Mar", 
                                       "Apr", "May", "Jun", "Jul", 
                                       "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] strs = date.split(" ");
        StringBuilder sb = new StringBuilder();
        
        sb.append(strs[2]);
        sb.append("-");
        for (int i = 0; i < months.length; ++i) {
            if (months[i].equals(strs[1])) {
                if (i + 1 < 10) {
                    sb.append("0");
                }
                sb.append(i + 1);
                sb.append("-");
            }
        }
        int day = Integer.valueOf(strs[0].substring(0, strs[0].length() - 2));
        if (day < 10) {
            sb.append("0");
        }
        sb.append(day);
        return sb.toString();
    }
}