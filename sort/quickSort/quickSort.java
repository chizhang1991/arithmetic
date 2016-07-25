// partitioning an array into two subarrays
// calling itself to quicksort each of these subarray
// > Partition the array or subarray into left (small keys) and right (larger keys) groups
// > Call ourselves to sort the left group
// > Call outselves again to sort the right group
////////////////////////////////
class ArrayQS {
	private long[] theArray;
	private int nElems;

	public ArrayQS(int max){
		theArray = new long[max];
		nElems = 0;
	}

	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}

	public void display() {
		System.out.print("The array is: ");
		for(int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}

	public int size() {
		return nElems;
	}

	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	public void recQuickSort(int left, int right) {
		if (left >= right) 
			return;
		else {
			long pivot = theArray[right];

			int partition = partitionIt(left, right, pivot);
			System.out.println("partition is: " + partition);
			recQuickSort(left, partition - 1);
			recQuickSort(partition + 1, right);
		}
	}

	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left -1; // ++left
		int rightPtr = right;  // --right

		while (true) {
			//left should be smaller than pivot
			// find bigger item >> ready to swap
			while(theArray[++leftPtr] < pivot)
				;
			// right: find smaller item
			while(rightPtr > 0 && theArray[--rightPtr] > pivot)
				;
			if(leftPtr >= rightPtr)
				break;
			else
				swap (leftPtr, rightPtr);
		}
		swap (leftPtr, right); // put pivot into 
		System.out.print("in process: ");
		display();
		return leftPtr;
	}

	public void swap(int left, int right) {
		long temp = theArray[left];
		theArray[left] = theArray[right];
		theArray[right] = temp;
	}
}

class QuickSortApp {
	public static void main (String args[]) {
		int maxSize = 100;
		ArrayQS arr = new ArrayQS(maxSize);

		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		//arr.insert(11);

		arr.display();

		arr.quickSort();

		arr.display();
	}
}