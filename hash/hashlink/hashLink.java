// separate chaining, 
// install a linked list at each index in the hash table
///////////////////////////////////
class Link {
	private int data;
	public Link next;

	public Link(int datavalue) {
		data = datavalue;
	}

	public int getKey() {
		return data;
	}

	public void displayLink() {
		System.out.print(data + " ");
	}
}

class LinkList {
	private Link first;

	public LinkList (){
		first = null;
	}

	public void insert(int datavalue) {
		Link temp = new Link(datavalue);

		temp.next = first;
		first = temp;
	}

	public void displayList() {
		Link current = first;
		System.out.print("first >>> last  ");
		if(first == null) {
			System.out.print("***");
		}
		else {
			while(current != null) {
				current.displayLink();
				current = current.next;
			}
		}
		System.out.println();
	}

	public Link delete(int datavalue) {
		Link current = first;
		Link previous = first;
		Link temp = null;

		if (first == null) {
			System.out.println("Delete, cannot find");
			return null;
		}

		else if(first.getKey() == datavalue) {
			temp = first;
			first = first.next;
			System.out.print("Delete successfully ");
			temp.displayLink();
			System.out.println();
			return temp;
		}

		else {
			while(current != null) {
				if (current.getKey() == datavalue){
					temp = current;
					previous.next = current.next;
				}
				previous = current;
				current = current.next;
			}
			if(temp == null) {
				System.out.println("Delete, cannot find");
				return temp;
			}
			else {
				System.out.print("Delete successfully");
				temp.displayLink();
				System.out.println();
				return temp;
			}
		}
	}

	public Link find (int datavalue) {
		Link current = first;
		while (current != null && current.getKey() != datavalue) {
			current = current.next;
		}
		if (current == null) {
			System.out.println("Find, cannot find");
			return current;
		}
		else {
			System.out.print("Find ");
			current.displayLink();
			System.out.println();
			return current;
		}
	}
}
//==========================================
class HashTable {
	private LinkList[] hashArray;
	private int arraySize;

	public HashTable (int size) {
		arraySize = size;
		// creat hashArray, every item is a linklist
		hashArray = new LinkList[arraySize];
		// fill the item with the linklist
		for(int j = 0; j < arraySize; j++) {
			hashArray[j] = new LinkList();
		}
	}

	public void displayHash() {
		for (int j = 0; j < arraySize; j++) {
			System.out.print(j + ": ");
			hashArray[j].displayList();
		}
	}

	public int hashFunc(int key) {
		return key % arraySize;
	}

	public void insertHash(int datavalue) {
		int index = hashFunc(datavalue);
		//Link temp = new Link(datavalue);
		hashArray[index].insert(datavalue);
	}

	public Link findHash(int datavalue) {
		int index = hashFunc(datavalue);
		Link temp = hashArray[index].find(datavalue);
		if (temp == null) 
			return null;
		else
			return temp;
	}

	public Link deleteHash(int datavalue) {
		int index = hashFunc(datavalue);
		Link temp = hashArray[index].delete(datavalue);
		if(temp == null)
			return null;
		else
			return temp;
	}
}
//=================================
class HashLinkApp {
	public static void main (String args[]) {
		System.out.println("Creat a hash table with at most 10 items");
		HashTable theHash = new HashTable(10);

		theHash.displayHash();
		System.out.println();

		theHash.insertHash(32);
		theHash.insertHash(52);
		theHash.insertHash(18);
		theHash.insertHash(27);
		theHash.insertHash(67);
		theHash.displayHash();
		System.out.println();

		theHash.insertHash(86);
		theHash.insertHash(25);
		theHash.insertHash(33);
		theHash.insertHash(75);
		theHash.insertHash(9);
		theHash.displayHash();
		System.out.println();

		theHash.findHash(10);
		theHash.findHash(52);
		theHash.findHash(67);

		theHash.displayHash();
		System.out.println();

		System.out.println("deleting 1");
		theHash.deleteHash(1);
		theHash.displayHash();
		System.out.println();
		System.out.println("deleting 52");
		theHash.deleteHash(52);
		theHash.displayHash();
		System.out.println();
		System.out.println("deleting 33");
		theHash.deleteHash(33);
		theHash.displayHash();
	}
}