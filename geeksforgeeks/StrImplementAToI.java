// { Driver Code Starts
    import java.util.Scanner;

    class StrImplementAToI
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while(t>0)
            {
                String str = sc.nextLine();
                
                GfG g = new GfG();
                System.out.println(g.atoi(str));
            t--;
            }
        }
    }// } Driver Code Ends
    
    
    /*You are required to complete this method */
    class GfG
    {
        int atoi(String str)
        {
            int num=0, multiplier=1;
            // flag to indicate negative number
            boolean neg = false;
            // traverse the string
            for(int i=str.length()-1; i>=0; i--) {
                char c = str.charAt(i);
                // first character
                if(i==0 && c=='-') {
                    neg=true;
                    break;
                }
                // invalid character
                if(!Character.isDigit(c)) return -1;
                
                // convert the character to number, multiply by 10, and add the prev num
                num = (c-'0') * multiplier + num;
                multiplier = multiplier*10;
            }
            
            // add the sign
            num = neg ? -num : num;
            return num;
        }
    }
    