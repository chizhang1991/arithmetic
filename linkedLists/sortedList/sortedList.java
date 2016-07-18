// sorted list
///////////////////////
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
//=========================
class SortLink {
	private Link first;

	public SortLink() {
		first = null;
	}
//-------------------------
	public boolean isEmpty() {
		return (first == null);
	}
//-------------------------
	public void insert(long datavalue) {
		Link current = first;
		Link previous = null; //Chi: 
		Link temp = new Link(datavalue);

		while((current != null) && datavalue > current.data) {
			previous = current;
			current = current.next;
		}
		if(previous == null)
			first = temp;
		else
			previous.next = temp;
		temp.next = current;
	}
//---------------------------
	public Link delete (long datavalue) {
		Link current = first;
		Link previous = null;
		Link temp;

		//Empty
		if (isEmpty()) {
			System.out.println("Empty, Cannot delete.");
			return null;
		}
		//not empty
		else {
			//find the item current
			while ((current != null) && (current.data != datavalue)) {
				previous = current;
				current = current.next;
			}
			// not find
			if (current == null) {
				System.out.println("Cannot find");
				return null;
			}
			// find the first one
			else if ((previous == null) && (current.data == datavalue)) {
				temp = current;
				first = first.next; // current first
				System.out.print("You just deleted: ");
				return temp;
			}
			// not the first one
			else {
				temp = current;
				previous.next = current.next;
				System.out.print("You just deleted: ");
				return temp;
			}
		}
	}	
//----------------------------
	public Link deleteFirst() {
		Link temp = first;
		first = first.next;
		return temp;
	}
//----------------------------
	public void displayList() {
		System.out.print ("The list is: (first >>> last) ");
		Link current = first;
		if(current == null) 
			System.out.print("The list trying to display is empty!");
		else {
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
		}
		System.out.println();
	}
}
//==============================
class SortApp {
	public static void main(String[] args) {
		SortLink theSort = new SortLink();

		theSort.displayList();
		//System.out.println(theSort.delete(55).data);
		
		theSort.insert(55);
		theSort.insert(22);

		theSort.displayList();

		theSort.insert(44);
		theSort.insert(11);
		theSort.insert(33);

		theSort.displayList();

		theSort.deleteFirst();
		theSort.displayList();

		//System.out.println(theSort.delete(11).data);
		System.out.println(theSort.delete(55).data);
		System.out.println(theSort.delete(33).data);
		theSort.displayList();

		System.out.println(theSort.delete(22).data);
		System.out.println(theSort.delete(44).data);
		theSort.displayList();

	}
}