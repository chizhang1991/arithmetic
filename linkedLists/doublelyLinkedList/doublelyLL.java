// doublely linked list
//////////////////////////
class Link {
	public long data;
	public Link next;
	public Link previous;

	public Link (long datavalue) {
		data = datavalue;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}
}
//===========================
class DoublelyLink {
	private Link first;
	private Link last;

	public DoublelyLink() {
		first = null;
		last = null;
	}
//---------------------------
	public boolean isEmpty() {
		return (first == null);
	}
//---------------------------
	public void insertFirst (long datavalue) {
		Link newLink = new Link (datavalue);
		if(isEmpty()) 
			last = newLink;
		else
			first.previous = newLink;
		newLink.next = first;
		first = newLink;
	}
//---------------------------
	public void insertLast (long datavalue) {
		Link newLink = new Link (datavalue);
		if(isEmpty())
			first = newLink;
		else
			last.next = newLink;
		newLink.previous = last;
		last = newLink;
	}
//---------------------------
	public void insertAfter (long keyvalue, long datavalue) {
		Link newLink = new Link (datavalue);
		Link current = first;

		while(current.data != keyvalue)
			current = current.next;

		Link temp = current.next;
		current.next = newLink;
		newLink.next = temp;
	}
//----------------------------
	public Link deleteFirst() {
		Link temp = first;
		// if the list is empty
		if(isEmpty()) {
			System.out.println("Empty");
			return null;
		}
		//the list is not empty
		else {
			//the list only have one item
			if(first.next == null)
				last = null;
			//the list has more than one item
			else 
				first.next.previous = null;
			first = first.next;
			return temp;
		}
	}
//---------------------------
	public Link deleteLast() {
		Link temp = last;
		//the list is empty
		if(isEmpty()) {
			System.out.println("Empty");
			return null;
		}
		//the list is not empty
		else {
			//the list only has one item
			if(last.previous == null)
				first = null;
			//the list has more than one item
			else
				last.previous.next = null;
			last = last.previous;
			return temp;
		}
	}
//----------------------------
	public void displayList() {
		Link current = first;
		if(isEmpty())
			System.out.println("Display: Empty");
		else {
			System.out.print("First >>>>> Last: ");
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}
}
//===============================
class DLLApp {
	public static void main (String[] args) {
		DoublelyLink theList = new DoublelyLink();

		theList.insertLast(11);
		theList.displayList();

		theList.insertFirst(22);
		theList.displayList();
		
		theList.insertFirst(33);
		theList.insertFirst(44);
		theList.insertFirst(55);
		theList.insertFirst(66);
		theList.insertFirst(77);
		theList.displayList();

		theList.deleteFirst();
		theList.displayList();

		theList.deleteLast();
		theList.displayList();

		theList.insertLast(88);
		theList.displayList();

		theList.insertLast(99);
		theList.displayList();
	}
}
