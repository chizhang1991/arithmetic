// bubble sort
// >>compare two numbers 
// >>if the left one is larger, swap them
// >>move one position right, until reach the right end
// bubbleSort.java BubbleSortApp
//////////////////////////////////////////////

class ArrayBub {

	private long[] a;
	private int nElems;
//------------------------------
	public ArrayBub(int max) {
		nElems = 0;
		a = new long[max];
	}
//------------------------------
	public void insert(long value) {
		a[nElems] = value;
		nElems++;
	}
//------------------------------
	public void display() {
		System.out.print("The array is: ");
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}
//------------------------------
	public void bubbleSort() {
		int out, in;

		for(out = 0; out < nElems-1; out++){
			/*
			System.out.print("in process: ");
			display();
			*/
			for(in = out+1; in < nElems; in++) {
				if (a[out] > a[in])
					swap(a[out],a[in]);
				else
					;
			}
		}
	}
//--------------------------------
	public void swap(long num1, long num2) {
		long temp = num1;
		num1 = num2;
		num2 = temp;
	}
}

///////////////////////////////////////

class BubbleSortApp {
	public static void main (String args[]) {
		int maxSize = 100;
		ArrayBub arr = new ArrayBub(maxSize);

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

		arr.display();

		arr.bubbleSort();

		arr.display();
	}
}