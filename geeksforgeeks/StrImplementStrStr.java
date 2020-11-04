// { Driver Code Starts
    import java.util.*;


    class StrImplementStrStr
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while(t>0)
            {
                String line = sc.nextLine();
                String a = line.split(" ")[0];
                String b = line.split(" ")[1];
                
                GfG g = new GfG();
                System.out.println(g.strstr(a,b));
                
                t--;
            }
        }
    }// } Driver Code Ends
    
    
    /*
    the function returns the 
    position where the target string 
    matches the string str
    
    Your are required to complete this method */
    
    class GfG
    {
        int strstr(String str, String target)
        {
          if(str.length() == 0) return -1;
          
          // start of the subtring
          int start=-1;
          int i=0;
          
          while(i < str.length()) {
              // first character in the target matches
              if(str.charAt(i) == target.charAt(0)) {
                  int j=0;
                  // store the start index as it could be a potential match
                  int temp = i;
                  // compare corresponding characters
                  while(i < str.length() && j < target.length()) {
                      // mismatch
                      if(str.charAt(i) != target.charAt(j))
                        break;
                    
                     i++; j++;
                  }
                  
                  // when j is at target length, it means all characters in target matched
                  if(j==target.length())
                    // return the start index
                    return temp;
              }
              // move ahead
              i++;
          }
          
          return start;
        }
    }
    