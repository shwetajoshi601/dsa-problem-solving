// { Driver Code Starts
    import java.util.*;
 
    class StrRunLengthEncoding
    {
       public static void main(String[] args) 
       {
     
          Scanner sc = new Scanner(System.in);
        
          int T = sc.nextInt();
          sc.nextLine();
          while(T>0)
          {
              
            String str = sc.nextLine();
            
            GfG g = new GfG();
            System.out.println(g.encode(str));
            
          
            T--;
          }
       }
    }
    
    // } Driver Code Ends
    
    
    class GfG
     {
        String encode(String str)
        {
            if(str.length() == 0) return str;
            
            StringBuilder sb = new StringBuilder();
            
            char prev = str.charAt(0);
            int count = 1;
            
            for(int i=1; i<str.length(); i++) {
                if(prev == str.charAt(i)) {
                    count ++;
                } else {
                    sb.append(prev);
                    sb.append(count);
                    count = 1;
                    prev = str.charAt(i);
                }
            }
            
            sb.append(prev);
            sb.append(count);
            
            String compressed = sb.toString();
            
            return compressed;
            // In CTCI, return the string with lower length
            // return compressed.length() < str.length() ? compressed : str;
        }
     }