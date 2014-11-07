/**
You are given an integer array with N elements: d[0], d[1], ... d[N - 1]. 
You can perform AT MOST one move on the array: choose any two integers [L, R], and flip all the elements between (and including) the L-th and R-th bits. L and R represent the left-most and right-most index of the bits marking the boundaries of the segment which you have decided to flip.
 
What is the maximum number of '1'-bits (indicated by S) which you can obtain in the final bit-string? 
 
'Flipping' a bit means, that a 0 is transformed to a 1 and a 1 is transformed to a 0 (0->1,1->0). 
Input Format 
An integer N 
Next line contains the N bits, separated by spaces: d[0] d[1] ... d[N - 1] 
 
Output: 
S 
 
Constraints: 
1 <= N <= 100000 
d[i] can only be 0 or 1 
0 <= L <= R < n 
 
Sample Input: 
8 
1 0 0 1 0 0 1 0 
 
Sample Output: 
6 
 
Explanation: 
 
We can get a maximum of 6 ones in the given binary array by performing either of the following operations: 
Flip [1, 5] ==> 1 1 1 0 1 1 1 0

**/


public class Vmware {
 
	public static void main(String[] args) {
		int[] a= new int[args.length];
		for (int i=0;i<args.length; i++){
			a[i]= Integer.parseInt(args[i]);
		}
		int maxnum=flip(a);
		System.out.println(maxnum);
					
		}
	public static int flip(int a[])	{
		int max=0;
		int count=0;
		int left,right;
		int[] b = new int[a.length];
		System.arraycopy( a, 0, b, 0, a.length );
		
		for(left=0;left<b.length;left++)	{
			for(right=left;right<b.length;right++)	{
				for(int i=left;i<=right;i++)	{
					if(b[i]==1)
						b[i]=0;
					else
						b[i]=1;
				}
				for(int j=0;j<b.length;j++)	{
					if(b[j]==1)
						count++;
				}
				b=new int[a.length];
				System.arraycopy( a, 0, b, 0, a.length );
				if(max<count)
					max=count;
				count=0;
			}
		}
		return max;
	}
 
	}
