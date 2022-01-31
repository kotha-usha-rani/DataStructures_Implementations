class StackImplementation<T>{
	T[] data;
	int top;
	StackImplementation(){
		data = new T[size];
		top = 0;
	}
	
	//to create a dynamic array
// 	public void increaseSize(){
// 		int[] newData = new int[data.length*2];
// 		for(int i=0 ; i<data.length ; i++){
// 			newData[i] = data[i];
// 		}
// 		data = newData;
// 	}
	//add elements at the top of the stack
	public void addElements(T value){
		//if dynamic array is used then
		//if(top == data.length)
		//increseSize();
		if(top == data.length-1){
			System.out.println("Stack overflow");
			return;
		}
		data[top++] = value;
	}

	//pop an element from the stack
	public T popElement(){
		if(top == 0){
			System.out.println("Stack underflow");
			return Integer.MIN_VALUE;
		}
		T ele = data[--top];
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
