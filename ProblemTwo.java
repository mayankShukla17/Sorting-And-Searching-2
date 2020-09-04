package Sorting_And_Searching_2;
/*Problem 2
Given an integer array of which both first half and second half are sorted, merge two 
sorted halves of the array into a single sorted array.
 */
import java.util.Scanner;
public class ProblemTwo {
	public static void mergeArrays(int[] array1, int[] array2, int size1,int size2, int[] array3) 
	{ 
		int i = 0, j = 0, k = 0; 
		while (i<size1 && j <size2) 
		{ 
			if (array1[i] < array2[j]) 
				array3[k++] = array1[i++]; 
			else
				array3[k++] = array2[j++]; 
		} 
		while (i < size1) 
			array3[k++] = array1[i++]; 
		while (j < size2) 
			array3[k++] = array2[j++]; 
	} 
	public static void main (String[] args)  
	{ 
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of arrays.");
		int size=scanner.nextInt();
		int array1[]=new int[size];
		System.out.println("Enter the Array1 elements");
		for (int i = 0; i < array1.length; i++) 
			array1[i]=scanner.nextInt();
		int array2[]=new int[size];
		System.out.println("Enter the Array2 elements");
		for (int i = 0; i < array2.length; i++) 
			array2[i]=scanner.nextInt();
		System.out.println("Original Array1: ");
		for (int i = 0; i < array1.length; i++) 
			System.out.print(array1[i]+" ");
		System.out.println("\n Original Array2: ");
		for (int i = 0; i < array2.length; i++) 
			System.out.print(array2[i]+" ");
		int[] array3 = new int[array1.length+array2.length]; 

		mergeArrays(array1, array2,array1.length,array2.length,array3); 

		System.out.println("\n Array after merging"); 
		for (int i=0; i < array3.length; i++) 
			System.out.print(array3[i] + " "); 
	} 
}
