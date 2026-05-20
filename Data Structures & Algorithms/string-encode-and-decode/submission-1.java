class Solution {

    public String encode(List<String> strs) {
        List<String> s = new ArrayList<>(); 
        for(String str : strs)
        {
            int len = str.length();
            StringBuilder sb = new StringBuilder();
            sb.append(len);
            sb.append('#');
            sb.append(str);
            s.add(sb.toString());
        }
        String result = String.join("", s);
        return result;
    }

    public List<String> decode(String str) {
        char[] cr = str.toCharArray();
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<cr.length)
        {
            StringBuilder sb = new StringBuilder();
            while(cr[i] != '#')
            {
                sb.append(cr[i++]);
            }
            i++;
            int len = Integer.parseInt(sb.toString());
            StringBuilder resSb = new StringBuilder();
            while(len>0)
            {
                resSb.append(cr[i++]);
                len--;
            }
            list.add(resSb.toString());
        }
        return list;
    }
}
