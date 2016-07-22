//abstract data type
//queue implemented as double-ended list
///////////////////////////////
class Link {
	public long data;
	public Link next;

	public Link (long datavalue) {
		data = datavalue;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}
}
//==============================
class LinkList {
	private Link first;
	private Link last;

	public LinkList () {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}
//---------------------------------
	public void insertFirst (long datavalue) {
		Link newLink = new Link(datavalue);
		if(isEmpty()) 
			last = newLink;
		newLink.next = first;
		first = newLink;
	}

	public void insertLast (long datavalue) {
		Link newLink = new Link(datavalue);
		if(isEmpty()) {
			first = newLink; // if the list is empty, after insert first = last = newLink
		}
		else
			last.next = newLink; 
		last = newLink;
	}
//---------------------------------
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
//-----------------------------
	public void displayList() {
		Link current = first;
		if(isEmpty())
			System.out.println("The list you are trying to display is empty.");
		else{
			while(current != null){
				current.displayLink();
				current = current.next;
			}
			System.out.println();
		}
	}
}
//============================
class LinkQueue {
	private LinkList theList;

	public LinkQueue() {
		theList = new LinkList();
	}
//----------------------------
	public void insert(long value) {
		theList.insertLast(value);
	}
//---------------------------
	public long remove(){
		Link temp = theList.deleteFirst();
		return temp.data;
	}
//----------------------------
	public boolean isEmpty() {
		return (theList.isEmpty());
	}
//---------------------------
	public void displayQueue() {
		System.out.print("The queue is front >> rear: ");
		theList.displayList();
	}
}
//===============================
class QueueApp {
	public static void main (String args[]) {

		LinkQueue theQueue = new LinkQueue();

		theQueue.insert(11);
		theQueue.insert(22);
		theQueue.insert(33);

		theQueue.displayQueue();

		theQueue.remove();
		theQueue.displayQueue();
		theQueue.remove();
		theQueue.remove();
		theQueue.displayQueue();
		//theQueue.remove();
		//theQueue.displayQueue();
	}
}