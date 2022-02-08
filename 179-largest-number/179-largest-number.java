class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int index = 0;
        for (int i : nums) {
            strs[index++] = String.valueOf(i);
        }
        Arrays.sort(strs, new Comparator<>(){
            @Override
            public int compare(String s1, String s2) {
                String num1 = s1 + s2;
                String num2 = s2 + s1;
                return num2.compareTo(num1);
            }
        });
        // print(strs);
        if(strs[0].charAt(0) == '0')
			return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
    private void print(String[] strs) {
        for (String s : strs) {
            System.out.print(s + " ");
        }
    }
}