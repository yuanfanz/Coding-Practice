class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String first = s.substring(0, len/2);
        String second = s.substring(len/2);
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < first.length(); ++i) {
            if (set.contains(first.charAt(i))) {
                count1++;
            }
            if (set.contains(second.charAt(i))) {
                count2++;
            }
        }
        return count1 == count2;
    }
}