class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        
        int prev = s.charAt(0) - '0';
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            int cur = s.charAt(i) - '0';
            if (prev != cur) {
                list.add(count);
                count = 1;
            } else {
                count++;
            }
            prev = cur;
        }
        list.add(count);
        int res = 0;
        // print(list);
        for (int i = 1; i < list.size(); ++i) {
            res += Math.min(list.get(i - 1), list.get(i));
        }
        return res;
    }
    
    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}