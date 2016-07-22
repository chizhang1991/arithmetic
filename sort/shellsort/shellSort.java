// Shell sort
// based on insertion sort
// insertion sorting widely spaced elements, increment h
// interval sequence h = 3*h + 1
///////////////////////////
class ArraySS {
	private long[] a;
	private int nElems;

	public ArraySS(int max) {
		a = new long[max];
		nElems = 0;
	}

	public void insert (long value) {
		a[nElems++] = value;
	}

	public void display() {
		System.out.print("The array is: ");
		for(int j = 0; j < nElems; j++) 
			System.out.print(a[j] + " ");
		System.out.println();
	}

	public void shellSort() {
		int outer;
		int inner;
		long marked;
		int h = 1;

		//find h
		while (3*h < nElems) 
			h = 3*h + 1;

		// h decreasing, sort
		while(h > 0) {
			// outer loop, h decreasing
			for (outer = h; outer < nElems; outer++) {
				inner = outer;
				marked = a[outer];

				// inner sort: insertion sort  rear >>> front
				// insert the marked element into the sorted part (on the left of the marked element)
				while (inner > h - 1 && a[inner - h] > marked) {
					a[inner] = a[inner - h];
					inner -= h;
				}
				a[inner] = marked;
			}
			h = (h-1) / 3;
		}
	}
}
//===========================
class shellApp {
	public static void main(String args[]) {

		int maxSize = 100;
		ArraySS arr = new ArraySS(maxSize);

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
		arr.insert(11);

		arr.display();

		arr.shellSort();

		arr.display();
	}
}