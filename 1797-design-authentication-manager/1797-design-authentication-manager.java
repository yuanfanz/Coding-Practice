class AuthenticationManager {
    // id, expire time
    Map<String, Integer> map;
    int unit;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        unit = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + unit);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (!map.containsKey(tokenId)) return;
        int expire = map.get(tokenId);
        if (expire <= currentTime) {
            return;
        }
        map.put(tokenId, currentTime + unit);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : map.keySet()) {
            int expire = map.get(key);
            if (expire > currentTime) {
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */