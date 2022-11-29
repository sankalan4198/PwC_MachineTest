package SECONDLARGESTELEMENT_CODE;

public class SecondLargest {

	public static void main(String[] args) {
		int arr[]= {100,200,150,180,20};
		
		int i, first, second;
		first=second=Integer.MIN_VALUE;
		
		for( i=0;i<arr.length;i++)
		{
			if(arr[i]>first)
			{
				second=first;
				first=arr[i];
			}
			else if(arr[i]>second && arr[i]!=first)
			{
				second=arr[i];
			}
		}
		
		System.out.println("The second largest element is the array is: "+second);
		
	}

}
