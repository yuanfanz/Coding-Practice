class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; ++i) {
            String cur = arr[i];
            if (cur.equals("") || cur.equals(".")) continue;
            if (cur.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) return "/";
        while (stack.size() > 0) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}