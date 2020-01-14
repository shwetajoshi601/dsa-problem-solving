import java.util.*;
class SortedArrayTransition
{  
    public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n =sc.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
			GfG obj = new GfG();
			System.out.println(obj.transitionPoint(arr,n));
			T--;
		}	
	}
}

/*This is a function problem.You only need to complete the function given below*/
class GfG
{
	int transitionPoint(int arr[],int n)
	{
             // Your code here
        if(n == 0)
            return 0;
    
        int mid = n/2;
        int pos = 0;
        if(arr[mid] == 0) {
            while(mid < n) {
                if(arr[mid] == 1) {
                    pos = mid; 
                    break;
                }
                mid++;
            }
        } else {
            while(mid >=0) {
                if(arr[mid] == 0) {
                    pos = mid+1;
                    break;
                }
                mid--;
            }
        }
        return pos;
    } 
}
