class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = (int) Math.pow(10, 9) + 7;
        
        long[] addToShare = new long[20001];
        addToShare[1 + delay] = 1;
        long[] toForget = new long[20001];
        toForget[1 + forget] = 1;
        
        long curKnow = 1;
        long canShare = 0;
        for (int i = 1; i <= n; ++i) {
            // on this day, some people can start to share
            // some people forget, cannot share anymore
            canShare += addToShare[i] - toForget[i];
            // canShare people share with newKnow people
            long newKnow = canShare;
            // newKnow people will be able to share after delay days
            addToShare[i + delay] += newKnow;
            addToShare[i + delay] %= mod;
            // newKnow people will forget after forget days
            toForget[i + forget] += newKnow;
            toForget[i + forget] %= mod;
            
            curKnow += newKnow - toForget[i];
            curKnow = curKnow % mod;
        }
        return (int) curKnow;
    }
}