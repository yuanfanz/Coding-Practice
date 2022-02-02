class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int i = 0;
        while (i < words.length) {
            StringBuilder sb = new StringBuilder();
            int total = 0;
            int j = i;
            while (j < words.length && total + words[j].length() <= maxWidth) {
                total += words[j++].length() + 1;
            }
            int len = 0;
            for (int k = i; k < j; ++k) {
                len += words[k].length();
            }
            int space = maxWidth - len;
            int num = j - i;
            if (num == 1) {
                sb.append(words[j - 1]);
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                result.add(sb.toString());
                i = j;
                continue;
            }
            int rem = space % (num - 1);
            int avg = space / (num - 1);
            for (int k = i; k < j; ++k) {
                sb.append(words[k]);
                if (k < j - 1) {
                    for (int h = 0; h < avg; ++h) {
                        sb.append(" ");
                    }
                    if (rem > 0) {
                        sb.append(" ");
                        rem--;
                    }
                }
            }
            result.add(sb.toString());
            i = j;
        }
        String last = result.get(result.size() - 1);
        String[] strs = last.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < strs.length; ++j) {
            if (strs[j].equals("")) continue;
            sb.append(strs[j]);
            if (j != strs.length - 1) {
                sb.append(" ");
            }
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        result.remove(result.size() - 1);
        result.add(sb.toString());
        return result;
    }
}