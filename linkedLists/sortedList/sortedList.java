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
/*
		if (isEmpty())
			first = temp;
		else {
			while ((current != null) && (current.data < datavalue)) {
				previous = current;
				current = current.next;
			}
			previous.next = temp;
			//temp.next = current;
		}
		temp.next = current;
*/
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
		//Link temp = first;
/*
		if (isEmpty()) { 
			System.out.println("The list is empty.");
			return null;
		}
		else {
			while((current != null) && (current.data != datavalue)) {
				previous = current;
				current = current.next;
			}
			Link temp = current;
			previous.next = current.next;
			System.out.print("The item has been deleted: ");
			return temp;
		}
*/
/*
		while((current != null) && (current.data != datavalue)) {
			//temp = current.next;
			previous = current;
			current = current.next;
		}
		
		if (current.data != datavalue) {
			System.out.println("Cannot find the item you want to delete");
			return null;
		}
		else if(first == null) {
			System.out.println("The list is empty. Cannot delete.");
			return null;
		}
		else {
			previous.next = current.next;
			System.out.print("The item has been deleted: ");
			return temp;
		}
*/
		while((current != null) && (current.data != datavalue)) {
			previous = current;
			current = current.next;
		}
		if (first == null) {
			System.out.println("The list is empty. Cannot delete.");
			return null;
		}
		else if (current.data != datavalue && current.next == null) {
			System.out.println("The list is empty. Cannot delete.");
			return null;
		}
		else{
			Link temp = current;
			previous.next = current.next;
			System.out.print("The item has been deleted: ");
			return temp;
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

		System.out.println(theSort.delete(22).data);
	}
}