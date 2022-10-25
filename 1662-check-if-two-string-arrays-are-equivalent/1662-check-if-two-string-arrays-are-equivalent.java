class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return getString(word1).equals(getString(word2));
    }
    
    private String getString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}