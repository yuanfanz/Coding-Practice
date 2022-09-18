class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        Map<String, List<Integer>> map = new HashMap<>();
        return dfs(expression, map);
    }
    private List<Integer> dfs(String expression, Map<String, List<Integer>> map) {
        if (map.containsKey(expression)) return map.get(expression);
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) {
            char ch = expression.charAt(i);
            
            if (!Character.isDigit(ch)) {
                List<Integer> left = dfs(expression.substring(0, i), map);
                List<Integer> right = dfs(expression.substring(i + 1), map);
                
                for (int num1 : left) {
                    for (int num2 : right) {
                        if (ch == '+') result.add(num1 + num2);
                        if (ch == '-') result.add(num1 - num2);
                        if (ch == '*') result.add(num1 * num2);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(expression));
        }
        map.put(expression, result);
        return result;
    }
}