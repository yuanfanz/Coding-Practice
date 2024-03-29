class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Integer> nameView = new HashMap<>();
        Map<String, String> nameId = new HashMap<>();
        Map<String, Integer> idView = new HashMap<>();
        
        for (int i = 0; i < ids.length; ++i) {
            String name_key = creators[i] + "_" + ids[i];
            idView.put(name_key, Math.max(idView.getOrDefault(name_key, 0), views[i]));
        }
        
        for (int i = 0; i < creators.length; ++i) {
            String name = creators[i];
            String id = ids[i];
            String name_key = creators[i] + "_" + ids[i];
            
            String lastId = nameId.getOrDefault(name, "NA");
            String last_name_key = creators[i] + "_" + lastId;
            if (lastId.equals("NA")) {
                nameId.put(name, id);
            } else {
                int high = idView.get(name_key);
                int lasthigh = idView.get(last_name_key);
                if (high >= lasthigh) {
                    if (high == lasthigh) {
                        if (id.compareTo(lastId) < 0) {
                            nameId.put(name, id);
                        }
                    } else {
                        nameId.put(name, id);
                    }
                }
            }
            nameView.put(name, nameView.getOrDefault(name, 0) + views[i]);
        }
        int max = 0;
        for (String key : nameView.keySet()) {
            max = Math.max(max, nameView.get(key));
        }
        List<String> list = new ArrayList<>();
        for (String key : nameView.keySet()) {
            if (nameView.get(key) == max) {
                list.add(key);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String name : list) {
            List<String> cur = new ArrayList<>();
            cur.add(name);
            cur.add(nameId.get(name));
            result.add(cur);
        }
        return result;
    }
}