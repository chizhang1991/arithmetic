// Abstract data types
// stack implemented by linked list
///////////////////////////////////
class Link {
	public long data;
	public Link next;

	public Link (long datavalue) {
		data = datavalue;
	}

	public void displayLink() {
		System.out.print (data + " ");
	}
}
//================================
class LinkList {
	private Link first;

	public LinkList () {
		first = null;
	}
//--------------------------------
	public void insertFirst (long value) {
		Link newLink = new Link (value);
		newLink.next = first;
		first = newLink;
	}
//-------------------------------
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
//-------------------------------
	public boolean isEmpty(){
		return (first == null);
	}
//--------------------------------
	public void displayList() {
		Link current = first;
		if(isEmpty()) 
			System.out.println("The list you are trying to display is Empty");
		else {
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
			System.out.println();
		}
	}
}
//===============================
class LinkStack {
	private LinkList theList;

	public LinkStack() {
		theList = new LinkList();
	}
//-------------------------------
	public void push (long value) {
		theList.insertFirst(value);
	}
//-------------------------------
	public long pop() {
		Link temp = theList.deleteFirst();
		return temp.data;
	}
/*//-------------------------------
	public long peek() {
	}
//-------------------------------*/
	public boolean isEmpty() {
		return (theList.isEmpty());
	}
//-------------------------------
	public void displayStack() {
		System.out.println("The stack is top >> bottom: ");
		theList.displayList();
	}
}
//===================================
class StackApp {
	public static void main (String args[]) {

		LinkStack theStack = new LinkStack();

		theStack.push(11);
		theStack.push(22);

		theStack.displayStack();

		theStack.push(33);

		theStack.displayStack();

		System.out.println("You just poped: " + theStack.pop());
		System.out.println("You just poped: " + theStack.pop());

		theStack.displayStack();
		theStack.pop();
		theStack.displayStack();
	}
}