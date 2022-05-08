class Solution {
    public String largestGoodInteger(String num) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i < num.length() - 1; ++i) {
            if (num.charAt(i - 1) == num.charAt(i) && num.charAt(i) == num.charAt(i + 1)) {
                set.add(num.charAt(i) - '0');
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int cur = list.get(list.size() - 1);
        sb.append(cur + "");
        sb.append(cur);
        sb.append(cur);
        return sb.toString();
    }
}