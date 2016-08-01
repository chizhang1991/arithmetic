// heap
// based on array
///////////////////////////
class Node {
	private int data;

	public Node (int datavalue) {
		data = datavalue;
	}

	public int getKey() {
		return data;
	}

	public void displayNode() {
		System.out.print(data + " ");
	}
}
//==========================
class HeapArray {
	private Node[] theHeap;
	private int maxSize;
	private int nElem;

	public HeapArray(int max) {
		maxSize = max;
		theHeap = new Node[maxSize];
		nElem = 0;

		for (int i = 0; i < maxSize; i++)
			theHeap[i] = null;
	}

	public boolean isEmpty() {
		return nElem == 0;
	}

	public boolean isFull() {
		return nElem == maxSize;
	}

	public void displayHeap() {
		System.out.println ("The heap is: ");
		for(int j = 0; j < nElem; j++) {
			System.out.print(j + "-- ");
			theHeap[j].displayNode();
			System.out.println();
		}
		System.out.println("--END--");
	}

	public boolean insert(int datavalue) {
		// is the heap full?
		if (isFull()) {
			System.out.println("Insert, the heap already full");
			return false;
		}
		// the heap not full
		else {
			Node newNode = new Node(datavalue);
			System.out.println("Insert successfully  " + datavalue);
			// insert the node in the tail
			theHeap[nElem++] = newNode;
			// up up up, parent larger child smaller
			moveUp(nElem-1);// nElem, the number of the items
			return true;
		}
	}

	public boolean remove() {
		// the array should not be empty
		if(isEmpty()) {
			System.out.println ("Remove, the heap is empty");
			return false;
		}
		// not empty
		else {
			// remove root, put theHeap[--nElem] --> root
			System.out.print("Remove successfully  ");
			theHeap[0].displayNode();
			System.out.println();
			theHeap[0] = theHeap[--nElem];
			// root move down
			moveDown();
			return true;
		}

	}

	public void moveUp(int theLast) { // theLast, subscript of the item
		Node tempNode = theHeap[theLast];
		int comp = theLast;
		int previous = theLast;
		// if insertion --> root
		if (theLast == 0)
			return;
		// not in the root
		else {
			previous = comp;
			comp = (comp - 1) / 2;
		}
		while(comp >= 0 && previous != comp && theHeap[comp].getKey() < tempNode.getKey()) {
			//tempNode = theHeap[comp];
			theHeap[previous] = theHeap[comp];
			previous = comp;
			comp = (comp - 1) / 2;
		}
		theHeap[previous] = tempNode;
		/*else {
			// compare left child
			if (comp % 2 == 1) {
				previous = comp;
				comp = (comp - 1) / 2;
			}
			// right child
			else {
				previous = comp;
				comp /= 2;
			}
			// compare find the right place
			while (comp >= 0 && previous != comp && theHeap[comp].getKey() < tempNode.getKey()) {
				if (comp % 2 == 1) {
					previous = comp;
					comp = (comp - 1) / 2;
				}
				else {
					previous = comp;
					comp /= 2;
				}
			}
			//tempNode change with previous
			// comp == previous --> root 
			if (theHeap[0].getKey() < tempNode.getKey()) {
				theHeap[theLast] = theHeap[0];
				theHeap[0] = tempNode;
			}
			else {
				theHeap[theLast] = theHeap[previous];
				theHeap[previous] = tempNode;
			}
		}
		return;
		*/
	}

	public void moveDown() {
		Node tempNode = theHeap[0];
		int comp = 0;
		int follow = 0;

		if (isEmpty()) 
			return;
		if (nElem == 1)
			return;
		// change with the larger child
		// the node has more than child
		while ((comp * 2 + 1) < nElem) {
			//only have leftchild
			if((comp * 2 + 2) == nElem)  {
				follow = comp;
				comp = comp * 2 + 1;
				if(theHeap[comp].getKey() > tempNode.getKey()) {
					//swap (0, follow);
					theHeap[follow] = theHeap[comp];
					theHeap[comp] = tempNode;
				}
				else
					theHeap[follow] = tempNode;
				return;
			}
			// have both left and right child
			// compare with the larger child
			else {
				if (theHeap[comp * 2 + 1].getKey() > theHeap[comp * 2 + 2].getKey()) {
					follow = comp;
					comp = comp * 2 + 1;
				}
				else {
					follow = comp;
					comp = comp * 2 + 2;
				}

				if(theHeap[comp].getKey() > tempNode.getKey()) {
					theHeap[follow] = theHeap[comp];
				}
				else 
					break;
			}
		}
		theHeap[comp] = tempNode;
	}
}
//================================
class HeapApp {
	public static void main(String args[]) {
		int maxSize = 31;
		HeapArray theHeap = new HeapArray(maxSize);

		theHeap.displayHeap();

		theHeap.insert(70);
		theHeap.insert(40);
		theHeap.insert(50);
		theHeap.insert(20);
		theHeap.insert(60);
		theHeap.insert(100);
		theHeap.insert(80);
		theHeap.insert(30);
		theHeap.insert(10);
		theHeap.insert(90);

		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();

		theHeap.remove();
		theHeap.displayHeap();
	}
}