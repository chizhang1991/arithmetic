// Hash tables
// >>based on arrays
// Double hashing
// >> it must not be the same as primary hsh function
// >> it mush never output a 0
// stepSize = constant - (key % constant);
// constant is prime and smaller than the array size
/////////////////////////
class DataItem {
	private int data;

	public DataItem(int datavalue) {
		data = datavalue;
	}

	public int getKey() {
		return data; // key is the data value
	}

	public void displayItem() {
		System.out.print(data + " ");
	}
}
//======================
class HashTable {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonItem; // use for delete
	private int constant; // use in hashFunc2;

	public HashTable(int size, int conValue) {
		hashArray = new DataItem[size];
		arraySize = size;
		nonItem = new DataItem(-1);
		constant = conValue;
	}

	public int hashFunc1(int key) {
		return key % arraySize;
	}

	public int hashFunc2(int key) {
		return constant - (key % constant);
	}

	public void displayHash() {
		System.out.print("The hash table is: ");
		for (int j = 0; j < arraySize; j++) {
			if (hashArray[j] != null) {
				System.out.print(hashArray[j].getKey() + " ");
			}
			else
				System.out.print("*" + " ");
		}
		System.out.println();
	}

	public void insert(int datavalue) {
		DataItem newItem = new DataItem(datavalue);
		int index = hashFunc1(datavalue);
		// hash the key a second time, using a different hash function, 
		// use the result as the stepSize
		int stepSize = hashFunc2(datavalue);
		// find where to insert
		// index2 = index;
		while(hashArray[index] != null) {
			index += stepSize;
			index %= arraySize;
		}
		hashArray[index] = newItem;
	}

	public DataItem find (int datavalue) {
		int index = hashFunc1(datavalue);
		int stepSize = hashFunc2(datavalue);

		while(hashArray[index] != null) {
			//found the item
			if(hashArray[index].getKey() == datavalue)
				return hashArray[index];
			else {
				index += stepSize;
				index %= arraySize;
			}
		}
		return null;
	}

	public DataItem delete (int datavalue) {
		int index = hashFunc1(datavalue);
		int stepSize = hashFunc2(datavalue);
		DataItem temp = null;

		while(hashArray[index] != null) {
			//found the item
			if(hashArray[index].getKey() == datavalue) {
				temp = hashArray[index];
				//hashArray[index] = null;
				System.out.println("Delete " + temp.getKey() + " successfully");
				hashArray[index] = null;
				return temp;
			}
			else {
				index += stepSize;
				index %= arraySize;
			}
		}

		System.out.println("Cannot delete!");
		return temp;
	}
}
//==========================
class hashTableApp {
	public static void main(String args[]) {
		System.out.println("Creat a hash table with at most 10 items");
		HashTable theHash = new HashTable(10, 5);

		theHash.displayHash();

		System.out.println("Insert 32, 52, 18, 27, 67");
		theHash.insert(32);
		theHash.insert(52);
		theHash.insert(18);
		theHash.insert(27);
		theHash.insert(67);
		theHash.displayHash();

		System.out.print("find 1: ");
		if(theHash.find(1) != null)
			theHash.find(1).displayItem();
		else
			System.out.print("Cannot find");
		System.out.println();

		System.out.print("find 52: ");
		if(theHash.find(52) != null)
			theHash.find(52).displayItem();
		else
			System.out.print("Cannot find");
		System.out.println();

		System.out.print("delete 1: ");
		theHash.delete(1);
		theHash.displayHash();

		System.out.print("find 18: ");
		if(theHash.find(18) != null)
			theHash.find(18).displayItem();
		else
			System.out.print("Cannot find");
		System.out.println();

		System.out.print("delete 32: ");
		theHash.delete(32);
		theHash.displayHash();

		System.out.print("delete 18: ");
		/*
		if(theHash.delete(18) != null) // delete(18) run the first time
			theHash.delete(18).displayItem(); // delete(18) run the second time, null can not display
		else
			System.out.print("no delete");
		System.out.println();
		*/
		// theHash.delete(18);
		// theHash.displayHash();

		DataItem temp = theHash.delete(27);
		temp.displayItem();
		System.out.println();
		theHash.displayHash();

	}
}