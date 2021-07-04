// { Driver Code Starts
    import java.util.Scanner;
    import java.util.Stack;
    class StackSortAStack {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0){
                Stack<Integer> s=new Stack<>();
                int n=sc.nextInt();
                while(n-->0)
                s.push(sc.nextInt());
                GfG g=new GfG();
                Stack<Integer> a=g.sort(s);
                while(!a.empty()){
                    System.out.print(a.peek()+" ");
                    a.pop();
                }
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    /*Complete the function below*/
    class GfG{
        
        void insert(Stack<Integer> st, int val) {
            if(st.isEmpty() || val >= st.peek()) {
                st.push(val);
                return;
            } else {
                // insert at the bottom
                int temp = st.pop();
                insert(st, val);
                st.push(temp);
            }
        }
        
        public Stack<Integer> sort(Stack<Integer> s)
        {
            Stack<Integer> st2 = new Stack<Integer>();
            
            while(!s.isEmpty())
                insert(st2, s.pop());
                
            return st2;

            // this can also be written as follows:
            /*
                if(!s.isEmpty()) {
                    int temp = s.pop();
                    sort(s);
                    insert(s, temp);
                }
                
                return s;
            /*
        }
    }