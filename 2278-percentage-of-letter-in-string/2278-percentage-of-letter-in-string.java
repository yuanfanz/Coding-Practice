class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == letter){
                count++;
            }
        }
        System.out.println(count);
        double res = (double) count / (double) (s.length());
        res *= 100;
        return (int)res;
    }
}