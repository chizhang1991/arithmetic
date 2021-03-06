// partition1.java

//////////////////////////////////////////////

class ArrayPar {
	private long[] theArray;
	private int nElems;
//---------------------------------------------
	public ArrayPar(int max) {
		theArray = new long[max];
		nElems = 0;
	}
//---------------------------------------------
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
//---------------------------------------------
	public int size(){
		return nElems;
	}
//---------------------------------------------
	public void display() {
		System.out.print("A = ");
		for(int j = 0; j < nElems; j++)
			System.out.print(theArray[j] + " ");
		System.out.println();
	}
//----------------------------------------------
	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right + 1;
		while(true) {
			while(leftPtr < rightPtr && theArray[++leftPtr] < pivot) {
				//System.out.print("leftPtr+1 " + leftPtr + " ");
				//System.out.print("rightPtr  " + rightPtr + " ");
			}
				; // find bigger items
			while(rightPtr > leftPtr && theArray[--rightPtr] > pivot) 
				; // find smaller items
			if(leftPtr >= rightPtr) 
				break;
			else
				swap(leftPtr, rightPtr);
		}
		return leftPtr;
	}
//-----------------------------------------------
	public void swap(int dex1, int dex2) {
		long temp;
		temp = theArray[dex1];
		theArray[dex1] = theArray[dex2];
		theArray[dex2] = temp;
	}
//------------------------------------------------
}
//////////////////////////////////////////////////
class PartitionApp {
	public static void main(String args[]) {
		int maxSize = 16;
		ArrayPar arr = new ArrayPar(maxSize);

		for(int j = 0; j < maxSize; j++) {
			long n = (int)(java.lang.Math.random() * 199);
			arr.insert(n);
		}
		//System.out.println("Begin: ");
		arr.display();
		//System.out.println("....................................");

		long pivot = 99;

		System.out.println("Pivot is " + pivot);
		int size = arr.size();

		int parDex = arr.partitionIt(0, size - 1, pivot);

		//System.out.println("....................................");
		//System.out.println("Done!");
		arr.display();
	}
}