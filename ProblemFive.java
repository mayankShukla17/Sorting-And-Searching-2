package Sorting_And_Searching_2;
/*Problem 5
Given an array of integers, segregate odd and even numbers in an array. 
Note: Order of elements can be changed.
For ex: arr[] = {12, 17, 70, 15, 22, 65, 21, 90}
Array after separating odd and even numbers :
{12, 90, 70, 22, 15, 65, 21, 17}
*/
import java.util.Scanner;
public class ProblemFive {
	public static int[] separateEvenOddNumbers(int array[])
	{
		int left=0;
		int right=array.length-1;
		for (int i = 0; i < array.length; i++) {

			while(array[left]%2==0)
			{
				left++;
			}
			while(array[right]%2==1)
			{
				right--;
			}

			if(left<right)
			{
				int temp=array[left];
				array[left]=array[right];
				array[right]=temp;
			}
		}
		return array;
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of array.");
		int size=scanner.nextInt();
		int array[]=new int[size];
		System.out.println("Enter the Array elements");
		for (int i = 0; i < array.length; i++) 
			array[i]=scanner.nextInt();
		System.out.println("Original Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		array=separateEvenOddNumbers(array);
		System.out.println("\nArray after separating even and odd numbers : ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
