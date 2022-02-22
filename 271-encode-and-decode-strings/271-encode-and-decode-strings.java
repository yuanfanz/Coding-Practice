public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int index = s.indexOf("/", i);
            int len = Integer.valueOf(s.substring(i, index));
            i = index + len + 1;
            String cur = s.substring(index + 1, i);
            result.add(cur);
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));