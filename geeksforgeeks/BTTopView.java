// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}


class BTTopView{
    
    public static void main(String[] args)throws IOException{
        //Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t=Integer.parseInt(br.readLine());
       
        while(t > 0)
           {
               Queue<Node> q = new LinkedList<>();
        
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().trim().split(" ");
            
            Node root = null;
            int j=0;
            while(n > 0){
            int a1 = Integer.parseInt(input[j]);
            int a2 = Integer.parseInt(input[j+1]);
            char lr = input[j+2].charAt(0);
            j+=3;
            
            if(root == null)
            {
                root = new Node(a1);
                q.add(root);
            }
            
            Node pick = q.peek();
            
            q.remove();
            
            if(lr=='L'){
                pick.left = new Node(a2);
                q.add(pick.left);
            }
            a1 = Integer.parseInt(input[j]);
            a2 = Integer.parseInt(input[j+1]);
            lr = input[j+2].charAt(0);
            j += 3;
            
            if(lr=='R'){
                pick.right = new Node(a2);
                q.add(pick.right);
            }
            
            n-=2;
        }
            ArrayList<Integer> res = new View().topView(root);
            for(int i=0; i<res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            t--;
        }
    }
}

   


// } Driver Code Ends


//User function Template for Java



/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Pair {
    int hd;
    Node node;
    
    Pair(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}

class View
{
    // function should print the topView of the binary tree
    static ArrayList<Integer> topView(Node root)
    {
        // Map of hd -> data
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int hd = curr.hd;
            Node node = curr.node;
            
            if(!map.containsKey(hd))
                map.put(hd, node.data);
            
            if(node.left != null)
                q.add(new Pair(hd-1, node.left));
                
            if(node.right != null)
                q.add(new Pair(hd+1, node.right));
        }
        
       ArrayList<Integer> result = new ArrayList<Integer>();
    //   System.out.println(map.size());
       for(Map.Entry<Integer, Integer> e: map.entrySet())
            result.add(e.getValue());
            
       return result; 
    }
}