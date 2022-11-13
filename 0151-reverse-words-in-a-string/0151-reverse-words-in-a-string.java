class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; --i) {
            String cur = arr[i].trim();
            if (cur.equals("")) continue;
            sb.append(cur + " ");
        }
        return sb.toString().trim();
    }
}