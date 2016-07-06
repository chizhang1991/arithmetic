// orderedArray.java
// binary search
///////////////////////////////
class OrdArray {
	private long[] a;
	private int nElems; // nElem is number of data items
	//-------------------------
	public OrdArray(int max){
		a = new long[max];
		nElems = 0;
	}
	//-------------------------
	public int size() {
		return nElems;
	}
	//-------------------------
	public void display(){
		for(int j = 0; j < nElems; j++)
			System.out.print(a[j] +  " ");
		System.out.println();
	}
	//--------------------------
	public void insert(long value){
		int j = 0;

		for (j = 0; j < nElems; j++){
			if (a[j] > value)
				break;
		}

 	// int i = nElems; ? nElem - 1
		for (int i  = nElems; i > j; i--)
			a[i] = a[i-1];

		a[j] = value;

		nElems++;
	}
	//---------------------------
	public int find(long searchKey){
		int highBound = nElems - 1;
		int lowBound = 0;
		int middle = 0;

		while(true)  {
			middle = (highBound + lowBound) / 2;

			if(a[middle] == searchKey)
				return middle;

			else if(lowBound > highBound)
				return nElems; 

			else{
			if (a[middle] > searchKey)
				highBound = middle - 1;
			else
				lowBound = middle + 1;
			}
		}
	}
	//--------------------------
	public boolean delete(long value) {
		int j = find(value);

		if (j == nElems)
			return false; // not found value

		else {
			for (int i = j; i < nElems; i++)
				a[i] = a[i+1];

			nElems--;

			return true; // Must nElem-- first!!!
		}
	}
}


/////////////////////////////////

class OrderApp {
	public static void main(String args[]){

		int maxSize = 100;
		OrdArray arr = new OrdArray(maxSize);

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

		System.out.println("How many numbers in array" + arr.size());
		arr.display();

		long searchKey = 00;
		//if(arr.find())
		System.out.print("Where is " + searchKey + " ");
		System.out.println(arr.find(searchKey));

		searchKey = 12;
		System.out.print("Where is " + searchKey + " ");
		System.out.println(arr.find(searchKey));

		arr.delete(33);
		arr.display();

		arr.delete(91);
		arr.display();
	}
}