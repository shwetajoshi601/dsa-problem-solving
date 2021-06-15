// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class StrAnagram {
        
        public static void main (String[] args)throws IOException {
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
            {
                String str = br.readLine();
                String s1 = str.split(" ")[0];
                String s2 = str.split(" ")[1];
                
                Solution obj = new Solution();
                
                if(obj.isAnagram(s1,s2))
                {
                    System.out.println("YES");
                }
                else
                {
                     System.out.println("NO");
                }
                
                
                
            }
        }
    }// } Driver Code Ends
    
    
    
    
    
    class Solution
    {    
        //Function is to check whether two strings are anagram of each other or not.
        public static boolean isAnagram(String a,String b)
        {
            if(a.length() != b.length())
                return false;
            
            // map to store frequencies
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            
            for(int i=0; i<a.length(); i++) {
                char c = a.charAt(i);
                map.put(c, map.getOrDefault(c, 0)+1);
            }
            
            for(int j=0; j<b.length(); j++) {
                char c = b.charAt(j);
                if(map.containsKey(c)) {
                    int freq = map.get(c).intValue();
                    if(freq == 0)
                        return false;
                        
                    map.put(c, --freq);
                } else
                    return false;
            }
            
            for(Map.Entry<Character, Integer> e: map.entrySet()) {
                if(e.getValue().intValue() > 0)
                    return false;
            }
            
            return true;
        }
    }