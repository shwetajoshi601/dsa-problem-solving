public class Day9StrIsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int s_len=s.length();
        int t_len=t.length();
        // both strings empty
        if(s_len==0 && t_len==0) return true;
        // s empty
        if(s_len==0 && t_len > 0) return true;
        // t empty
        if(s_len>0 && t_len==0) return false;
        
        if((s_len==1 && t_len==1) && s.charAt(0) != s.charAt(0)) return false;
        
        int i=0, j=0;
        
        while(i< s_len && j<t_len) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        
        if(i==s_len) return true;
        else return false;
    }
}