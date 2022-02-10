class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i : nums) {
            list.add(String.valueOf(i));
        }
        Collections.sort(list, (a, b) -> (b+a).compareTo(a+b));
        if (list.get(0).charAt(0) == '0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}