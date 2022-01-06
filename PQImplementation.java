//Implementation of a Min Priority Queue using ArrayList
import java.util.Scanner;
import java.util.ArrayList;
class PriorityQueue{
	private ArrayList<Integer> heap ; //Arrays have fixed size which is a drawback, therefore use arraylist which is dynamic
	public PriorityQueue(){
		heap = new ArrayList<>();
	}
	//to get the minimum element
	public int getMin(){
		return heap.get(0); // the first element is the min element
	}

	//to get the size of the heap
	public int getSize(){
		return heap.size();
	}

	//to check if heap is empty
	public boolean isEmpty(){
		return heap.size() == 0 ;
	}

	//insert element into a heap
	public void insertElement(int ele){
		// just like adding an element into an arraylist, but this addition at the end of the arraylist might not satisfy heap order property
		//the element added will be a left or right child of its parent if viewed as Complete Binary Tree
		heap.add(ele); 

		//therefore to make it a heap
		int childIndex = heap.size()-1;
		int parentIndex = (childIndex-1)/2 ;
		while(childIndex > 0){
			if(heap.get(childIndex) < heap.get(parentIndex)){
				//swap the elements to satisfy heap order property
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);

				//the current parent will be the child as we got upwords, up-heapify
				//parent index can be calculated using childIndex
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2 ;
			}
			//if the child and parent are ordered according to heap order property then there is no need to check the other nodes/parents
			else
				return;
		}

	}

	//remove an element from the Priority Queue, here min element will be removed
	public void removeElement(){
		//the last element will be inserted at the root, delete the last element as it is duplicated
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		//rearrange the elements to satisfy heap order property
		int l = 1;
		int r = 2 ;
		int n = heap.size();
		int smallest = 0 ;
		int currSmallest = smallest ;
		while(l<n || r<n){
			smallest = currSmallest ;
			if(l<n && heap.get(l) < heap.get(currSmallest))
				currSmallest = l ;
			if(r<n && heap.get(r) < heap.get(currSmallest))
				currSmallest = r ;
			if(heap.get(currSmallest) != heap.get(smallest)){
				int temp = heap.get(currSmallest);
				heap.set(currSmallest, heap.get(smallest));
				heap.set(smallest, temp);
				smallest = currSmallest ;
				l = 2*smallest + 1 ;
				r = 2*smallest + 2 ;
			}
			else
				return;
		}

	}
}
public class PQImplementation{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the elements of PriorityQueue (Enter -1 to stop): ");
		int ele = sc.nextInt();
		PriorityQueue pq = new PriorityQueue();
		while(ele != -1){
			pq.insertElement(ele);
			ele = sc.nextInt();
		}
		System.out.println(pq.getMin());
		pq.removeElement();
		System.out.println(pq.getMin());
	}
}