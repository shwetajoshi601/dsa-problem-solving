// { Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class GFG
    {
        public static void main (String[] args)
        {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for(int i=0;i<t;i++){
                String s = in.next();
                if (new Sol().isPossible (s) == 1)
                    System.out.println ("Yes");
                else
                    System.out.println ("No");
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Sol
    {
        int isPossible (String S)
        {
            // get frequency counts
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            
            for(int i=0; i<S.length(); i++) {
                char c = S.charAt(i);
                
                if(Character.isLetter(c))
                    map.put(c, map.getOrDefault(c, 0)+1);
            }
            
            int oddCount = 0;
            
            for(Map.Entry<Character, Integer> e: map.entrySet()) {
                int freq = e.getValue().intValue();
                if(!(freq%2 == 0))
                    oddCount++;
            }
            
            return oddCount < 2 ? 1 : 0;
        }
    }