import java.util.*;
class SortedArrayTransitionBS
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
        int start =0, end=n-1;
        int mid = 0;
        while(start<=end) {
            mid = start + (end-start) / 2;
            if(arr[mid] == 1 && arr[mid-1] == 0)
                return mid;
            
            if(arr[mid] == 1)
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
	}
}
