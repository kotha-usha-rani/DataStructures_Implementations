class StackImplementation{

}
class Stack{
	int[] data;
	int top;
	Stack(int size){
		data = new int[size];
		top = 0;
	}
	//add elements at the top of the stack
	public void addElements(int value){
		if(top == data.length-1){
			System.out.println("Stack overflow");
			return;
		}
		data[top++] = value;
	}

	//pop an element from the stack
	public int popElement(){
		if(top == 0){
			System.out.println("Stack underflow");
			return Integer.MIN_VALUE;
		}
		int ele = data[--top];
		return ele;
	}

	//return top element
	public int getTop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		return data[top-1];
	}

	//return the size of the stack
	public int getSize(){
		return top == 0 ? 0 : top;
	}

	//check if stack is empty
	public boolean isEmpty(){
		return top == 0 ;
	}

}