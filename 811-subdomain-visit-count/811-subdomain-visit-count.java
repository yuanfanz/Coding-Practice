class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : cpdomains) {
            String[] strs = s.split(" ");
            int num = Integer.valueOf(strs[0]);
            String domain = strs[1];
            // System.out.println(domain);
            String[] doms = domain.split("\\.");
            
            map.put(domain, map.getOrDefault(domain, 0) + num);
            if (doms.length == 2) {
                map.put(doms[1], map.getOrDefault(doms[1], 0) + num);
            } else if (doms.length == 3) {
                map.put(doms[2], map.getOrDefault(doms[2], 0) + num);
                String subdom = doms[1] + "." + doms[2];
                map.put(subdom, map.getOrDefault(subdom, 0) + num);
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        return result;
    }
}