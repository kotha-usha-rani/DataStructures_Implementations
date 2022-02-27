import java.util.ArrayList;
class MinHeapImplementation{
	public static void main(String[] args){
		PriorityQueue minHeap = new PriorityQueue();
		minHeap.insertElement(10);
		minHeap.insertElement(4);
		minHeap.insertElement(6);
		minHeap.insertElement(12);
		minHeap.insertElement(2);
		minHeap.insertElement(67);
		minHeap.deleteElement();
		minHeap.deleteElement();
	}
}
class PriorityQueue{
	ArrayList<Integer> minHeap;
	PriorityQueue(){
		minHeap = new ArrayList<>();
	}
	public void print(){
		System.out.println(minHeap);
	}
	public int getMinElement(){
		if(minHeap.isEmpty())
			return -1;
		return minHeap.get(0);
	}
	public void insertElement(int element){
		minHeap.add(element);
		int childIndex = minHeap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex > 0){
			if(minHeap.get(parentIndex) > minHeap.get(childIndex)){
				int temp = minHeap.get(parentIndex);
				minHeap.set(parentIndex, minHeap.get(childIndex));
				minHeap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else{
				this.print();
				return;
			}
		}
		this.print();
	}

	public void deleteElement(){
		minHeap.set(0, minHeap.get(minHeap.size()-1));
		minHeap.remove(minHeap.size()-1);
		int parentIndex = 0;
		int leftChild = 1 ;
		int rightChild = 2 ;
		while(parentIndex < minHeap.size()-1){
			int minIndex = parentIndex;
			if(leftChild < minHeap.size()){
				if(rightChild < minHeap.size() && minHeap.get(leftChild) > minHeap.get(rightChild) && arr[rightChild] < arr[maxIndex])
					minIndex = rightChild;
				else if(minHeap.get(leftChild) < minHeap.get(minIndex))
					minIndex = leftChild;
			} 
			if(parentIndex != minIndex){
				int temp = minHeap.get(parentIndex);
				minHeap.set(parentIndex, minHeap.get(minIndex));
				minHeap.set(minIndex, temp);
				parentIndex = minIndex;
				leftChild = 2*parentIndex+1;
				rightChild = 2*parentIndex+2;
			}
			else{
				this.print();
				return;
			}
		}
		this.print();
	}

	
}
