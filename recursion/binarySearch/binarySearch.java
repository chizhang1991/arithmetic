// binary search
// recursive binary search
//////////////////////////
class OrdArray {
	private long[] a;
	private int nElem;

	public OrdArray (int max) {
		a = new long [max];
		nElem = 0;
	}
//-------------------------
	public void insert (long value) {
		int j = 0;
		while(j<nElem && a[j] < value)
			j++;
		for (int i = nElem; i > j; i--)
			a[i] = a[i-1];
		a[j] = value;
		nElem++;
	}
//-------------------------
	public int size () {
		return nElem;
	}
//-------------------------
	public void display () {
		if (nElem == 0) {
			System.out.println("The array is empty.");
		}
		else {
			System.out.print("The array is: ");
			for (int j = 0; j < nElem; j++)
				System.out.print(a[j] + " ");
			System.out.println();
		}
	}
//-------------------------
	public int find (long value) {
		return findRec(value, 0, nElem-1);
	}
	public int findRec (long value, int lower, int upper) {
		int j = (lower + upper) / 2;
		//find
		if (a[j] == value)
			return j;
		//cannot find
		else if(lower > upper)
			return nElem;
		//refine
		else {
			if(a[j] > value)
				return findRec(value, lower, j-1);
			else
				return findRec(value, j+1, upper);
		}
	}
}
//===========================
class RecbinaryApp {
	public static void main(String args[]) {
		OrdArray theArr = new OrdArray (100);
		int t;

		theArr.display();
		theArr.insert(1);
		theArr.display();
		
		t = theArr.find(1);
		if (t == theArr.size())
			System.out.println("cannot find");
		else
			System.out.println("You can find it : a[" + t + "]");

		theArr.insert(5);
		theArr.display();

		t = theArr.find(1);
		if (t == theArr.size())
			System.out.println("cannot find");
		else
			System.out.println("You can find it : a[" + t + "]");

		theArr.insert(3);
		theArr.insert(9);
		theArr.insert(7);
		theArr.insert(4);
		theArr.display();

		t = theArr.find(5);
		if (t == theArr.size())
			System.out.println("cannot find");
		else
			System.out.println("You can find it : a[" + t + "]");

		theArr.insert(6);
		theArr.display();

		t = theArr.find(9);
		if (t == theArr.size())
			System.out.println("cannot find");
		else
			System.out.println("You can find it : a[" + t + "]");

	}
}