// { Driver Code Starts

    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String args[]) throws IOException {
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String S[] = read.readLine().split(" ");
                
                int n = Integer.parseInt(S[0]);
                int k = Integer.parseInt(S[1]);
    
                Solution ob = new Solution();
                System.out.println(ob.safePos(n,k));
            }
        }
    }// } Driver Code Ends
    
    
    
    class Solution {
        static int safePos(int n, int k) {
            // List<Integer> persons = new LinkedList<Integer>();
            
            // for(int i=1; i<=n; i++) {
            //     persons.add(i-1, i);
            // }
            // k=k-1;
            // return findSurvivor(persons, k, 0);
            if(n==1)
                return n;
            else
            // in each iteration n-1 persons remain after killing 1, 
            // the next position is given by previous killed index+k%n+1
            // we do k-1 for zero based indexing
                return (safePos(n-1, k) + (k-1)) % n + 1;
        }
        
        static int findSurvivor(List<Integer> persons, int k, int start) {
            if(persons.size() == 1)
                return persons.get(0);
                
            start = (start+k) % persons.size();
            persons.remove(start);
            return findSurvivor(persons, k, start);
        }
    };