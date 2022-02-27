//implementation of maxHeap
import java.util.ArrayList;
class MaxHeapImplementation{
	public static void main(String[] args){
		PriorityQueue maxHeap = new PriorityQueue();
		maxHeap.insertElement(10);
		maxHeap.insertElement(4);
		maxHeap.insertElement(6);
		maxHeap.insertElement(12);
		maxHeap.insertElement(2);
		maxHeap.insertElement(67);
		maxHeap.deleteElement();
		System.out.println(maxHeap.getMaxElement());
		maxHeap.deleteElement();


	}
}
class PriorityQueue{

	//use dynamic array

	ArrayList<Integer> maxHeap;
	PriorityQueue(){
		maxHeap = new ArrayList<>();
	}

	public boolean isEmpty(){
		return maxHeap.isEmpty();
	}

	public int getMaxElement(){
		if(maxHeap.isEmpty())
			return -1;
		return maxHeap.get(0);
	}

	//add the element at the end of the maxHeap, 
	//do upheapify, to make it a maxHeap
	// compare the values of child and parent 
	// swap the two if child > parent
	//otherwise return -> not necessory to check if the entire tree
	// is a maxHeap as the other leaf nodes satisfy the maxHeap property

	public void insertElement(int element){
		maxHeap.add(element);
		int childIndex = maxHeap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex > 0){
			if(maxHeap.get(parentIndex) < maxHeap.get(childIndex)){
				int temp = maxHeap.get(parentIndex);
				maxHeap.set(parentIndex, maxHeap.get(childIndex));
				maxHeap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
	}

	//replace the first element with the last element
	//remove the last element
	//Now check if the tree statisfies maxHeap property
	//do downHeapify
	//compare the values of parent, leftChild, rightChild and 
	//swap if the left of right child has a value greater than the parent
	//other wise return
	//as the rest of the tree satisfies maxHeap property

	public void deleteElement(){
		maxHeap.set(0, maxHeap.get(maxHeap.size()-1));
		maxHeap.remove(maxHeap.size()-1);
		int parentIndex = 0;
		int leftChild = 1;
		int rightChild = 2 ;
		while(parentIndex < maxHeap.size()-1){
			int maxIndex = parentIndex;
			if(leftChild < maxHeap.size()){
				if(rightChild<maxHeap.size() && maxHeap.get(leftChild) < maxHeap.get(rightChild))
					maxIndex = rightChild;
				else
					maxIndex = leftChild ;
			}
			if(maxHeap.get(parentIndex) < maxHeap.get(maxIndex)){
				int temp = maxHeap.get(parentIndex);
				maxHeap.set(parentIndex, maxHeap.get(maxIndex));
				maxHeap.set(maxIndex, temp);
				parentIndex = maxIndex;
				leftChild = 2*parentIndex+1;
				rightChild = 2*parentIndex+2;
			}
			else
				return;
		}
	}
}
