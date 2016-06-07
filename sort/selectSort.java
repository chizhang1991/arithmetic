// selection sort
// >>find the smallest element
// >>swap with the most left one
// >>search from the second left element
// selectSort.java SelectSortApp
///////////////////////////////////

class ArraySel {

	private long[] a;
	private int nElems;
//------------------------------
	public ArraySel(int max) {
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
//-------------------------------
	public void selectSort() {
		int min;
		for (int out = 0; out < nElems-1; out++) {
			min = out;
			for (int in = out+1; in < nElems; in++) {
				if (a[min] > a[in]) {
//					System.out.println("before a[temp], a[in]" + a[temp] + " " + a[in]);
					swap(min, in);
//					System.out.println("after a[temp], a[in]" + a[temp] + " " + a[in]);
				}
			}
			swap(out, min);
		}
	}
//-------------------------------
	public void swap(int one, int two) {    //swap between two elements
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
/////////////////////////////////
class SelectSortApp {
	public static void main (String args[]) {
		int maxSize = 100;
		ArraySel arr = new ArraySel(maxSize);

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

		arr.selectSort();

		arr.display();
	}
}