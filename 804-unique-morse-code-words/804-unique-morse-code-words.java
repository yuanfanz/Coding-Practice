class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".",
                                        "..-.","--.","....","..",".---",
                                        "-.-",".-..","--","-.","---",".--.",
                                        "--.-",".-.","...","-","..-","...-",
                                        ".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String s : words) {
            String n = "";
            for (int i = 0; i < s.length(); ++i) {
                n = n + morse[s.charAt(i) - 'a'];
            }
            set.add(n);
        }
        return set.size();
    }
}