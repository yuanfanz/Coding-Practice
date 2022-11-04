class Solution {
    public String reverseVowels(String s) {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        StringBuilder rev = sb.reverse();
        int index = 0;
        sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (set.contains(s.charAt(i))) {
                sb.append(rev.charAt(index++));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}