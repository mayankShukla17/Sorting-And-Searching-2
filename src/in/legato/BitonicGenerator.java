package in.legato;
/*Problem 4
Given an array of n distinct numbers, sort all even-placed numbers in increasing and 
odd-placed numbers in decreasing order. The modified array should contain all sorted 
even-placed numbers followed by reverse sorted odd-placed numbers.
Note: the first element is considered as even placed because of its index 0. 
 */
import java.util.*;
public class BitonicGenerator {
	static void bitonicGenerator(int array[], int size) 
	{ 
		int i = 1; 
		int j = size - 1; 
		if (j % 2 != 0) 
			j--; 
		while (i < j) { 
			array = swap(array, i, j); 
			i += 2; 
			j -= 2; 
		} 
		Arrays.sort(array, 0, (size + 1) / 2); 
		Arrays.sort(array, (size + 1) / 2, size); 
		int low = (size + 1) / 2, high = size - 1; 
		while (low < high) { 
			Integer temp = array[low]; 
			array[low] = array[high]; 
			array[high] = temp; 
			low++; 
			high--; 
		} 
	} 
	static int[] swap(int[] array, int i, int j) 
	{ 
		int temp = array[i]; 
		array[i] = array[j]; 
		array[j] = temp; 
		return array; 
	} 
	public static void main(String[] args) 
	{ 
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
		System.out.println();
		bitonicGenerator(array, array.length); 
		for (int i = 0; i <array.length; i++) 
			System.out.print(array[i] + " "); 
	} 
}

