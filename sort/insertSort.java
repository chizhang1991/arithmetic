// insertion sort
// >> partially sorted: sorted -- marked element -- unsorted
// >> insert the marked element in the sorted part
// insertSort.java InsertSortApp

///////////////////////////////////////////////

class ArrayIns {

	private long[] a;
	private int nElem;
//---------------------------------------------
	public ArrayIns (int max) {
		nElem = 0;
		a = new long[max];
	}
//---------------------------------------------
	public void insert (long value) {
		a[nElem] = value;
		nElem++;
	}
//---------------------------------------------
	public void display() {
		System.out.print("The array is: ");
		for(int j = 0; j < nElem; j++) 
			System.out.print(a[j] + " ");
		System.out.println();
	}
//----------------------------------------------
	public void insertSort() {
		long marked;

		for (int out = 1; out < nElem; out++) {
			marked = a[out];
			int in = out;
			while (in > 0 && a[in-1] > marked) {
				a[in] = a[in-1];
				in--;
			}
			a[in] = marked;
		}
	}
}
/////////////////////////////////////////////////
class InsertSortApp {
	public static void main(String args[]) {

		int maxSize = 100;
		ArrayIns arr = new ArrayIns(maxSize);

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

		arr.insertSort();

		arr.display();
	}
}