// queue
// first in first out

///////////////////////////////////////////

class Queue {

	private int maxSize;
	private long[] queueArray;
	private int front;
	private int tail;
	private int nItems;
//-----------------------------------------
	public Queue(int max) {
		maxSize = max;
		queueArray = new long[maxSize];
		front = 0;
		tail = -1; 
		nItems = 0;
	}
//-----------------------------------------
	public void display() {
		System.out.print("The queue is: ");
		for (int j = 0; j < nItems; j++)
			System.out.print(queueArray[j] + " ");
	}
//-----------------------------------------
	public void insert(long value) {
		if(tail == maxSize -1) //the queue already full
			tail = -1;
		queueArray[++tail] = value;
		nItems++;
	}
//-----------------------------------------
	public long remove() {
		long value = queueArray[front++];
		nItems--;
		if (front == maxSize) // front different with tail 
			front = 0;
		return value;
	}
//----------------------------------------
	public long peek() {
		return queueArray[front];
	}
//----------------------------------------
	public int size() {
		return nItems;
	}
//---------------------------------------
	public boolean isFull() {
		return (nItems == maxSize);
	}
//---------------------------------------
	public boolean isEmpty() {
		return (nItems == 0);
	}
}
/////////////////////////////////////////
class QueueApp {
	public static void main (String args[]) {

		Queue theQueue = new Queue(10);

		theQueue.insert(20);
		theQueue.insert(40);
		theQueue.insert(60);
		theQueue.insert(80);

		System.out.println("The size of the queue is " + theQueue.size());
		theQueue.display();
		System.out.println();
		System.out.println(theQueue.peek());

		while (!theQueue.isEmpty()) {
			long value = theQueue.remove();
			System.out.print(value + " ");
		}
		System.out.println();
	}
}