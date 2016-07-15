// double ended list

///////////////////////////////

class Link {
	public long data;
	public int key;
	public Link next;

	public Link (int keyvalue, long datavalue) {
		data = datavalue;
		key = keyvalue;
	}

	public void displayLink () {
		System.out.print( data + " ");
	}
}
//================================
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
	public void insertFirst (int keyvalue, long datavalue) {
		Link newLink = new Link(keyvalue, datavalue);
		if(isEmpty()) 
			last = newLink;
		newLink.next = first;
		first = newLink;
	}

	public void insertLast (int keyvalue, long datavalue) {
		Link newLink = new Link(keyvalue, datavalue);
		if(isEmpty()) {
			first = newLink;
		}
		last.next = newLink;
		last = newLink;
	}
//---------------------------------
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
//----------------------------------
	public void displayList() {
		System.out.print("The List is first >> last: ");
		Link current;
		current = first;
		if (current == null) {
			System.out.println("The list you are trying to display is empty ~~~");
		}
		else {
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
			System.out.println (".......END");
		}
	}
}
//////////////////////////////////
class flListApp {
	public static void main (String args[]) {
		LinkList theList = new LinkList();

		System.out.println("Now, let's creat a list from first :D");
		theList.insertFirst(0, 11);
		theList.insertFirst(1, 22);
		theList.insertFirst(2, 33);
		theList.insertFirst(3, 44);
		theList.insertFirst(4, 55);
		theList.insertFirst(5, 66);
		theList.insertFirst(6, 77);

		theList.displayList();

		System.out.println("Delete the list");
		while(!theList.isEmpty()) {
			Link del = theList.deleteFirst();
			del.displayLink();
		}
		System.out.println("After delete first >> last: ");
		theList.displayList();

		System.out.println();
		System.out.println("Creat a list from the last: ");
		theList.insertLast(0, 11);
		theList.insertLast(1, 22);
		theList.insertLast(2, 33);
		theList.insertLast(3, 44);
		theList.insertLast(4, 55);
		theList.insertLast(5, 66);
		theList.insertLast(6, 77);

		theList.displayList();

		System.out.println("Delete the list");
		while(!theList.isEmpty()) {
			Link del = theList.deleteFirst();
			del.displayLink();
		}
		System.out.println("After delete first >> last: ");		
		theList.displayList();
	}
}