class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < keyName.length; ++i) {
            List<Integer> times = map.getOrDefault(keyName[i], new ArrayList<>());
            times.add(getTime(keyTime[i]));
            map.put(keyName[i], times);
        }
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);  // sort to find the connective checkins
            for (int i = 2; i < list.size(); i++)
                if (list.get(i) - list.get(i - 2) <= 60) {  // connective 3 within 60 mins.
                    result.add(name);
                    break;
                }
        }
        Collections.sort(result);
        return result;
    }
    
    private int getTime(String time) {
        String[] strs = time.split(":");
        int hour = Integer.valueOf(strs[0]);
        int minute = Integer.valueOf(strs[1]);
        return hour * 60 + minute;
    }
}