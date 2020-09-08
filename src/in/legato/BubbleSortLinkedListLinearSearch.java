package in.legato;
/*Problem 6
1) Create a function to accept the details of 5 Items in String.
2) Create function to arrange the items in ascending order using bubble sort
3)Create a function to add the sorted items to linked list 
4)Create a function to  find any one of the items in the linked list and then display 
the item details to user - linear search 
 */
import java.util.*;
import Sorting_And_Searching_2.LinkedList.Node;
public class BubbleSortLinkedListLinearSearch {
	public static void main(String[] args) {
		ProblemSix problem=new ProblemSix();
		String[] elements=problem.intputElements();
		System.out.println("Entered elements");
		for (int i = 0; i < elements.length; i++) 
			System.out.print(elements[i]+" ");
		String[] sortedElements=problem.bubbleSort(elements);
		System.out.println("\nSorted Elements");
		for (int i = 0; i < sortedElements.length; i++) 
			System.out.print(sortedElements[i]+" ");
		LinkedList llist = new LinkedList(); 
		Node new_node; 
		for (int i = 0; i < sortedElements.length; i++) {
			new_node = llist.newNode(Integer.parseInt(sortedElements[i]));
			llist.sortedInsert(new_node); 
		}	
		System.out.println("\nCreated Linked List"); 
		llist.printList(); 
		System.out.println("\nEnter the element you want to search");
		Scanner scanner=new Scanner(System.in);
		int search=scanner.nextInt();
		if (llist.search(llist.head, search)) 
			System.out.println("Yes element is present "+search); 
		else
			System.out.println("No element is not present"); 
	}
	private String[] bubbleSort(String[] elements) {
		String string[] = elements;
		String temp;
		for (int j = 0; j < string.length; j++) {
			for (int i = j + 1; i < string.length; i++) {
				if (string[i].compareTo(string[j]) < 0) {
					temp = string[j];
					string[j] = string[i];
					string[i] = temp;
				}
			}
		}
		return string;
	}
	public String[] intputElements() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of Elements.");
		int size=scanner.nextInt();
		String elementsArray[]=new String[size];
		System.out.println("Enter the Elements of array.");
		for (int i = 0; i < elementsArray.length; i++) 
			elementsArray[i]=scanner.next();
		return elementsArray;
	}
}
class LinkedList { 
	Node head; 
	class Node { 
		int data; 
		Node next; 
		Node(int d) 
		{ 
			data = d; 
			next = null; 
		} 
	} 
	void sortedInsert(Node new_node) 
	{ 
		Node current; 
		if (head == null || head.data >= new_node.data) { 
			new_node.next = head; 
			head = new_node; 
		} 
		else { 
			current = head; 
			while (current.next != null && current.next.data < new_node.data) 
				current = current.next; 

			new_node.next = current.next; 
			current.next = new_node; 
		} 
	} 
	Node newNode(int data) 
	{ 
		Node x = new Node(data); 
		return x; 
	} 
	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
	} 
	public boolean search(Node head, int x) 
	{ 
		if (head == null) 
			return false; 
		if (head.data == x) 
			return true; 
		return search(head.next, x); 
	}
} 
