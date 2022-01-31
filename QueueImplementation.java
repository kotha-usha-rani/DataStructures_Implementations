class QueueImplementation<T>{
	T[] queue;
	int front;
	int rear;
	int size;
	int capacity;
	QueueImplementation(int capacity){
		queue = new T[capacity];
		this.capacity = capacity;
		front = -1;
		rear = 0;
		size = 0 ;
	}
	//add element
	public void enqueue(T element){
		if(size == queue.length){
			System.out.println("Queue s full");
			return ;
		}
		if(front == -1)
			front++;
		queue[index] = element;
		int index = (rear+1)%capacity;
		size++;
	}
	//dequeue element
	public T dequeue(){
		if(size == 0){
			System.out.println("Queue is empty");
			return 0;
		}
		T ele = queue[front];
		front = (front+1)%capacity;
		size--;
		if(size == 0){
			front = -1;
			rear=  0 ;
		}
		return ele;
	}

	//size of the queue
	public int getSize(){
		return rear-front+1;
	}

}