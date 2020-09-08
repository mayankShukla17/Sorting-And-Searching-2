package com.stackroute;
/*Problem 3
Given a singly linked list and a key, find the key using the binary search approach.
*/
class SinglyLinkedListBinarySearch 
{
    //Node class
	static class Node 
	{ 
	    int data; 
	    Node next; 
	    Node(int d) 
	    { 
	        data = d; 
	        next = null; 
	    } 
	} 
	  //Method for adding node
    static Node push(Node head, int data) 
    { 
        Node newNode = new Node(data); 
        newNode.next = head; 
        head = newNode; 
        return head; 
    } 

    //Method for adding node in middle
    static Node middleNode(Node start, Node last)  
    { 
        if (start == null) 
            return null; 
  
        Node slow = start; 
        Node fast = start.next; 
  
        while (fast != last) 
        { 
            fast = fast.next; 
            if (fast != last)  
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
        return slow; 
    } 

    //Method for Binary Search
    static Node binarySearch(Node head, int value)  
    { 
        Node start = head; 
        Node last = null; 
        do
        { 
            Node mid = middleNode(start, last); 
  
            if (mid == null) 
                return null; 
  
            if (mid.data == value) 
                return mid; 
  
            else if (mid.data > value)  
            { 
                start = mid.next; 
            } 
            else
                last = mid; 
        } while (last == null || last != start); 
        return null; 
    } 

    //Main method Runner Code
    public static void main(String[] args)  
    { 
        Node head = null; 
  
        head = push(head, 1); 
        head = push(head, 4); 
        head = push(head, 7); 
        head = push(head, 8); 
        head = push(head, 9); 
        head = push(head, 10); 
        int value = 10; 
  
        if (binarySearch(head, value) == null) 
        { 
            System.out.println("Data is not present"); 
        }  
        else
        { 
            System.out.println("Data is present."); 
        } 
    } 
} 