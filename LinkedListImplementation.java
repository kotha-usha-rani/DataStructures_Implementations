class LinkedListImplementation{
	public static void main(String[] args){
		Node head = addNodeAtBegin(10, null);
		head = addNodeAtBegin(20, head);
	}
}
class Node{
	int data ;
	Node next;
	Node(int data){
		this.data = data ;
		this.next = null;
	}
	//add node at the start of the linked list
	public Node addNodeAtBegin(int data, Node head){
		Node newNode = new Node(data);
		newNode.next = head;
		return newNode;
	}

	//add node at the end of the linked list
	public Node addNodeAtEnd(int data, Node head){
		Node newNode = new Node(data);
		if(head == null)
			return newNode;
		Node temp = head ;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	//add node at position
	public Node addNodeAtPosition(int data, Node head, int position){
		if(position == -1)
			return head;
		Node newNode = new Node(data);
		if(position == 1){
			head.next = newNode;
			return newNode;
		}
		Node temp = head;
		while(temp != null && position > 2){
			temp = temp.next;
			position--;
		}
		if(temp == null || position > 2){
			System.out.println("Invalid position");
			return head;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}
	//delete node at the start of the linked list
	public Node deleteAtBegin(Node head){
		if(head == null)
			return null;
		Node temp = head.next;
		head = temp;
		return head;
	}
	//delete node at the end of the linked list
	public Node deleteAtEnd(Node head){
		if(head == null)
			return null;
		Node temp = head;
		while(temp.next.next != null){
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}
	//delete node at the position of the linked list
	public Node deleteAtPosition(Node head, int position){
		if(head == null)
			return null;
		if(position == 1){
			Node temp = head.next;
			head = temp;
			return head;
		}
		Node temp = head;
		while(temp != null && position > 2){
			temp = temp.next ;
			position--;
		}
		if(temp == null){
			System.out.println("Invalid position");
			return head;
		}
		temp.next = temp.next.next;
		return head;
}