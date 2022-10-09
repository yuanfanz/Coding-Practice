class Solution {
    public int[] findArray(int[] pref) {
        int cur = pref[0];
        
        int[] res = new int[pref.length];
        res[0] = cur;
        for (int i = 1; i < pref.length; ++i) {
            int next = cur ^ pref[i];
            cur = cur ^ next;
            res[i] = next;
        }
        return res;
    }
}