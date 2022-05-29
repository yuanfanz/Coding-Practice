class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; ++i) {
            String s = strs[i];
            if (s.charAt(0) == '$' && s.substring(1).indexOf('$') == -1
               && s.substring(1).length() > 0 && s.substring(1).chars().allMatch( Character::isDigit )) {
                
                // System.out.println(s.substring(1));
                
                double cur = Double.valueOf(s.substring(1));
                // System.out.println(cur);
                cur = cur * ((double)(100 - discount) / 100);
                sb.append("$");
                sb.append(String.format("%.2f", cur));
            } else {
                sb.append(s);
            }
            if (i != strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}