class Solution {
   class Node{
        private String username;
        private int timestamp;
        private String website;
        Node(String username,int timestamp,String website){
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        };
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //按名字归集

        Map<String,List<Node>> map = new HashMap<>();

        for(int i =0;i<username.length;i++){
            List<Node> list = map.getOrDefault(username[i], new ArrayList<>());
            list.add(new Node(username[i],timestamp[i],website[i]));
            map.put(username[i], list);
        }

        Map<String,Integer> scoreMap = new HashMap<>();

        //时间戳排序

        for (Map.Entry<String,List<Node>> entry:map.entrySet()) {
            // 对于每一个用户，有一连串的访问行为（node）
            List<Node> value = entry.getValue();

            // 形成一个pattern至少要三个访问
            if(value.size()>=3){

                //时间戳排序
                // value.sort(Comparator.comparingInt(o -> o.timestamp));
                Collections.sort(value, (a, b) -> a.timestamp - b.timestamp);

                Set<String> threeSet = new HashSet<>();

                //列举出时序内符合的所有三连模式
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i+1; j < value.size(); j++) {
                        for (int k = j+1; k < value.size(); k++) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(value.get(i).website).append(",");
                            sb.append(value.get(j).website).append(",");
                            sb.append(value.get(k).website);

                            // 这里很重要，每一个用户的三连不能重复计分
                            //（三连自己重复了也不能计分）
                            String key = sb.toString();
                            if(!threeSet.contains(key)){
                                threeSet.add(key);
                                scoreMap.put(key,scoreMap.getOrDefault(key,0)+1);
                            }
                        }
                    }
                }
            }
        }
        String[] result = new String[1];
        int max = 0;
        for (String key : scoreMap.keySet()) {
            if (max == scoreMap.get(key)) {
                if (key.compareTo(result[0]) < 0) {
                    max = scoreMap.get(key);
                result[0] = key;
                }
            } else if (max < scoreMap.get(key)) {
                max = scoreMap.get(key);
                result[0] = key;
            }
        }
        List<String> res = new ArrayList<>(Arrays.asList(result[0].split(",")));
        return res;
    }
}
