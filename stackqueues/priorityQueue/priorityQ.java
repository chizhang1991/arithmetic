// Priority queue
// A front and a rear, items remove from the front
// Items are ordered by key value -- lowest key is always at the front
// Items are inserted in the proper position to maintain the order
// priorityQ.java  the key is the value of the items

/////////////////////////////////
class Priority {
	private long[] priorityArr;
	private int maxSize;
	//private int front;
	//private int tail;
	private int nItems;
//-------------------------------
	public Priority (int max) {
		maxSize = max;
		priorityArr = new long[maxSize];
		//front = 0;
		//tail = -1;
		nItems = 0;
	}
//--------------------------------
	public void insert (long value) {
		int j;
		if (nItems == 0)
			priorityArr[0] = value;
		else {
			for (j = 0; j < nItems; j++) {
				if (priorityArr[j] > value)
					break;
			}
			for (int i = nItems; i > j; i--)
				priorityArr[i] = priorityArr[i-1];
			priorityArr[j] = value;
		}
		nItems++;
	}
//---------------------------------
	public long remove() {
		//if(nItems == 0) 
		//	break;
		long value = priorityArr[0];
		for(int j = 0; j < nItems - 1; j++)
			priorityArr[j] = priorityArr[j + 1];
		nItems--;
		return value;
	}
//----------------------------------
	public long peek() {
		return priorityArr[0];
	}
//---------------------------------
	public void display() {
		System.out.print("The priority queue is ");
		for(int j = 0; j < nItems; j++) {
			System.out.print(priorityArr[j] + " ");
		}
		System.out.println();
	}
//----------------------------------
	public boolean isEmpty() {
		return (nItems == 0);
	}
//----------------------------------
	public boolean isFull() {
		return (nItems == maxSize);
	}
//----------------------------------
	public int size() {
		return nItems;
	}
}
/////////////////////////////////////
class PriorityApp {
	public static void main(String args[]) {
		Priority theQueue = new Priority(10);

		theQueue.insert(50);
		theQueue.insert(20);
		theQueue.insert(30);
		theQueue.insert(10);
		theQueue.insert(60);
		theQueue.insert(40);

		System.out.println("The size of the queue is " + theQueue.size());
		theQueue.display();
		System.out.println();
		System.out.println(theQueue.peek());

		while (!theQueue.isEmpty()) {
			long value = theQueue.remove();
			System.out.println(value + " ");
		}
		System.out.println();
	}
}