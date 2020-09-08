package com.stackroute;
/*Problem 1
1. Create function to accept the details of 10 products(product name- String)
2. Create function to arrange the elements in descending order using insertion sort
3. Create a function to find any one of the product in the given list and then display
the product details to user - binary search
 */
import java.util.*;
public class InsertionSortBinarySearch {
	//Method for Inserting values
	public String[] intputProducts() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of products.");
		int size=scanner.nextInt();
		String productArray[]=new String[size];
		System.out.println("Enter the product details.");
		System.out.println("Enter the product Name");
		for (int i = 0; i < productArray.length; i++) 
			productArray[i]=scanner.next();
		return productArray;
	}

	// MergeSort method
	public String[] mergeSort(String[] productArray) {
		String [] sorted = productArray;
		if (productArray.length == 1) {
			sorted = productArray;
		} else {
			int mid = productArray.length/2;
			String[] left = null; 
			String[] right = null;
			if ((productArray.length % 2) == 0) {
				left = new String[productArray.length/2];
				right = new String[productArray.length/2];
			} else { 
				left = new String[productArray.length/2];
				right = new String[(productArray.length/2)+1];
			}
			int x=0;
			int y=0;
			for ( ; x < mid; x++) {
				left[x] = productArray[x];
			}
			for ( ; x < productArray.length; x++) {
				right[y++] = productArray[x];
			}
			left = mergeSort(left);
			right = mergeSort(right);
			sorted = mergeArray(left,right);
		}
		String[] descendingSorted=sorted;
		Arrays.sort(descendingSorted,Comparator.reverseOrder());
		return descendingSorted;
	}

	//Method for merging two arrays
	private String[] mergeArray(String[] left, String[] right) {
		String[] merged = new String[left.length+right.length];
		int lIndex = 0;
		int rIndex = 0;
		int mIndex = 0;
		int comp = 0;
		while (lIndex < left.length || rIndex < right.length) {
			if (lIndex == left.length) {
				merged[mIndex++] = right[rIndex++];
			} else if (rIndex == right.length) {
				merged[mIndex++] = left[lIndex++];
			} else {  
				comp = left[lIndex].compareTo(right[rIndex]);
				if (comp > 0) {
					merged[mIndex++] = right[rIndex++];
				} else if (comp < 0) {
					merged[mIndex++] = left[lIndex++];
				} else { 
					merged[mIndex++] = left[lIndex++];
				}
			}   
		}
		return merged;
	}

	//Method for Binary search
	public int binarySearch(int left, int right, String search, String[] productArray)
	{
		if (right >= left) {
			int mid = left + (right - left) / 2;
			if (productArray[mid].compareTo(search) == 0)
				return mid;
			if (productArray[mid].compareTo(search) < 0)
				return binarySearch(left, mid - 1, search, productArray);
			return binarySearch(mid + 1, right, search, productArray);
		}
		return -1;
	}

	//Main Method Runner Code
	public static void main(String[] args) {
		InsertionSortBinarySearch product=new InsertionSortBinarySearch();
		String[] products=product.intputProducts();
		String[]  sortedProducts=product.mergeSort(products);
		System.out.println("Product details.");
		for (int i = 0; i < sortedProducts.length; i++) 
			System.out.print(sortedProducts[i]+" ");
		System.out.println(" \n Enter the Product you want to search");
		Scanner scanner=new Scanner(System.in);
		String searchProduct=scanner.next();
		int result=product.binarySearch(0,sortedProducts.length,searchProduct,sortedProducts);
		if (result == -1) 
			System.out.println("Product not present"); 
		else
			System.out.println("Product found at index " + result); 
	}
}
