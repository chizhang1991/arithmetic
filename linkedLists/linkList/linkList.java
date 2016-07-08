// linked list

////////////////////////////
class Link {
	public long data;
	public int key;
	public Link next;
//-------------------------
	public Link (int keyvalue, long value) {
		data = value;
		key = keyvalue;
	}
//-------------------------
	public void displayLink () {
		System.out.print (data + ", ");
	}
}
//===========================
class LinkList {
	private Link first;
//------------------------
	public LinkList () {
		first = null;
	}
//---------------------------
	public boolean isEmpty() {
		return (first == null);
	}
//---------------------------
	public void insertFirst(int keyvalue, long value) {
		Link newLink = new Link(keyvalue, value);
		newLink.next = first;
		first = newLink;
	}
//-----------------------------
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
//---------------------------
	public Link find(int keyvalue) {
		Link current = first;
		if (current == null) {
			System.out.println("The linked list is empty");
			return null;
		}
		else {
			while (current != null) {
				if (current.key == keyvalue)
					return current;
				else
					current = current.next;
			}
		}
		System.out.println("The item not found ~~>_<~~");
		return null;
	}
//---------------------------
	public Link deleteKey(int keyvalue) {
		Link current = first;
		Link previous = first;
		Link temp;

		if(current == null) {
			System.out.println("The list is empty.");
		}
		else {
			if (first.key == keyvalue) {
				temp = first;
				first = first.next;
				return temp;
			}
			else {
				while(current != null) {
					previous = current;
					current = current.next;

					if (current.key == keyvalue) {
						temp = current;
						previous.next = current.next;
						return temp;
					}
				}
				System.out.println("The item you are trying to delete was not found");
			}
		}
		return null;
	}
}
//============================
class LinkListApp {
	public static void main (String args[]) {
		LinkList theList = new LinkList();

		System.out.println("Now, let's creat a list :D");
		theList.insertFirst(0, 11);
		theList.insertFirst(1, 22);
		theList.insertFirst(2, 33);
		theList.insertFirst(3, 44);
		theList.insertFirst(4, 55);
		theList.insertFirst(5, 66);
		theList.insertFirst(6, 77);

		theList.displayList();

		System.out.println("Find 5: ");
		Link temp = theList.find(5);
		if(temp != null){
			System.out.print("found it: ");
			temp.displayLink();
			System.out.println();
		}

		System.out.println("Find 8: ");
		temp = theList.find(8);
		if(temp != null) {
			System.out.print("found it: ");
			temp.displayLink();
			System.out.println();
		}

		System.out.println("Delete 5: ");
		temp = theList.deleteKey(5);
		if(temp != null) {
			System.out.print("deleted it: ");
			temp.displayLink();
			System.out.println();
		}

		theList.displayList();

		System.out.println("Delete 0: ");
		temp = theList.deleteKey(0);
		if(temp != null) {
			System.out.print("deleted it: ");
			temp.displayLink();
			System.out.println();
		}

		theList.displayList();
		
/**/
		System.out.println("Delete 8: ");
		temp = theList.deleteKey(8);
		if(temp != null){
			System.out.print("deleted it: ");
			temp.displayLink();
			System.out.println();
		}
/**/		
		System.out.println("delete all the elements: ");
		while (!theList.isEmpty()) {
			Link del = theList.deleteFirst();
			del.displayLink();
		}
		System.out.println();

		System.out.println("After delete: ");
		theList.displayList();

		System.out.println("Find 5: ");
		temp = theList.find(5);
		if(temp != null)
			System.out.println("found it: " + temp);
	}
}